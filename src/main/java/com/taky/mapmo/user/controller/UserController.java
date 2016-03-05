package com.taky.mapmo.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.taky.mapmo.check.model.UserChecker;
import com.taky.mapmo.check.service.CheckService;
import com.taky.mapmo.user.model.Awaiter;
import com.taky.mapmo.user.model.User;
import com.taky.mapmo.user.model.UserProfile;
import com.taky.mapmo.user.service.AwaiterService;
import com.taky.mapmo.user.service.UserService;

/**
 * 
 * @author SeongTak.Yoon
 *
 */
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AwaiterService awaiterService;
	
	@Autowired
	private CheckService checkService;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String requestJoin() throws Exception {
		logger.info("### 신규 가입을 요청하여 회원가입 페이지로 이동합니다.");
		return "user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String submitJoin(Awaiter awaiter) throws Exception {
		logger.info("### 신규 회원 가입 정보 제출.");
		
		UserChecker existUser = checkService.checkUser(awaiter.getId());
		if (existUser.isExist()) {
			return "이미 ID가 존재합니다. 회원가입을 하실 수 없습니다!";
		}
		
		//TODO 화면단 방어로직 다시 필요함 서버단체크 필수
		// 암호화 확인 
		
		awaiterService.registerAwatier(awaiter);
		
		
		return "맵모 회원이 되신 것을 환영합니다!";
	}
	
	@RequestMapping(value = "/signin")
	public ModelAndView registUser() throws Exception {
		userService.registUser();
		
		ModelAndView model = new ModelAndView("signin/signin");
		model.addObject("result", "SUCCESS NEW USER");
		
		return model;
	}
	
	@RequestMapping(value = "/search/user/id/{id}")
	@ResponseBody
	public UserChecker searchUserId(@PathVariable("id") String id) throws Exception {
		return checkService.checkUser(id);
	}
	
	@RequestMapping(value = "/show/profile", method = RequestMethod.GET)
	public ModelAndView showProfile() throws Exception {
		logger.info("### 유저 프로필 보기");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setProfileImageUrl("http://localhost:8080/static/image/u92-brown-thum.png");
		
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject(userProfile);
		
		return mav;
	}
	
	@RequestMapping(value = "/upload/profile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadProfile(@RequestParam("profileImage") MultipartFile profileImage) throws Exception {
		logger.debug("파일업로드시작");
		
		if (profileImage.isEmpty()) {
			return "파일 업로드에 실패하였습니다.";
		} 
		
		try {
			logger.debug("파일존재");
			logger.debug(profileImage.getOriginalFilename());
			byte[] bytes = profileImage.getBytes();
			
			File file = new File(System.getProperty("user.home") + "/static/image/upload");
			
			if (file.isDirectory() == false) {
				file.mkdirs();
			}
			logger.debug(file.getAbsolutePath());
			logger.debug(file.toURI().toString());
			//BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			//bos.write(bytes);
			//bos.close();
			
			File upload = new File(file.getAbsolutePath() + "/" + profileImage.getOriginalFilename());
			
			logger.debug(upload.getAbsolutePath());
			profileImage.transferTo(upload);
			
		} catch(Exception e) {
			logger.error("### 파일을 업로드하는 과정에서 문제가 발생하였습니다!", e);
		}
		
		return "파일이 업로드 되었습니다.";
	}
	
	@RequestMapping(value = "/download/{name}", method = RequestMethod.GET, produces = "image/png")
	@ResponseBody
	public ResponseEntity<InputStreamResource> downloadFile(@PathVariable("name") String name, HttpServletResponse response) throws Exception {
		logger.debug("### 다운로드 고고");
		
		File file = new File(System.getProperty("user.home") + "/static/image/upload/" + name +".png");
		InputStream is = new FileInputStream(file);
		
		// 이게 있어야 파일이 다운로드됨, 안그러면 걍 브라우저에서 열림
		response.setHeader("Content-Disposition", "attachment;filename=" + name + ".png");
		
		return ResponseEntity.ok().body(new InputStreamResource(is));
	}

	@RequestMapping(value = "/download/fs/{name}", method = RequestMethod.GET, produces = "image/png")
	@ResponseBody
	public FileSystemResource downloadByFileSystem(@PathVariable("name") String name, HttpServletResponse response) throws Exception {
		logger.debug("### 다운로드 고고2222");
		
		// 이게 있어야 파일이 다운로드됨, 안그러면 걍 브라우저에서 열림
		response.setHeader("Content-Disposition", "attachment;filename=" + name + ".png");
		
		return new FileSystemResource(new File(System.getProperty("user.home") + "/static/image/upload/" + name +".png"));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AwaiterService getAwaitService() {
		return awaiterService;
	}

	public void setAwaitService(AwaiterService awaitService) {
		this.awaiterService = awaitService;
	}

	public CheckService getCheckService() {
		return checkService;
	}

	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}
}

package com.taky.mapmo.check.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taky.mapmo.check.model.UserChecker;
import com.taky.mapmo.user.model.Awaiter;
import com.taky.mapmo.user.model.User;
import com.taky.mapmo.user.service.AwaiterService;
import com.taky.mapmo.user.service.UserService;

@Service
public class CheckServiceImpl implements CheckService {
	private static final String USER = "user";

	private static final String AWAITER = "awaiter";

	@Autowired
	private AwaiterService awaiterService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * <pre>
	 * 대기자(awaiter)를 먼저 찾아보고 없으면
	 * 유저(user)를 찾는다.
	 * </pre>
	 * 
	 * @param id 찾을 ID
	 * @return 체크한 정보를 담는 모델
	 */
	@Override
	public UserChecker checkUser(String id) throws Exception {
		Awaiter awaiter = awaiterService.findAwatier(id);
		
		if (awaiter == null) {
			return this.findUser(id);
		} else {
			return this.createUserChecker(awaiter.getId(), true, AWAITER);
		}
	}
	
	@Override
	public UserChecker checkUserByEmail(String email) throws Exception {
		Awaiter awaiter = new Awaiter();
		awaiter.setEmail(email);

		Awaiter existAwaiter = awaiterService.findAwaiter(awaiter);
		
		// 대기 목록에 없으면 유저 찾기
		if (existAwaiter == null) {
			User user = new User();
			user.setEmail(email);
			
			return this.findUser(user);
		} else {
			return this.createUserChecker(existAwaiter.getId(), true, AWAITER);
		}
	}


	private UserChecker findUser(String id) throws Exception {
		User user = userService.findUser(id);
		
		if (user == null) {
			return this.createUserChecker(null, false, USER);
		} else {
			return this.createUserChecker(user.getId(), true, USER);
		}
	}
	
	private UserChecker findUser(User user) throws Exception {
		User existUser = userService.findUser(user);
		
		if (existUser == null) {
			return this.createUserChecker(null, false, USER);
		} else {
			return this.createUserChecker(existUser.getId(), true, USER);
		}
	}
	
	/**
	 * 유저 정보를 조회한 결과에 대한 모델을 생성한다.
	 * 
	 * @param id 유저 아이디
	 * @param isExist 존재하는지 판단
	 * @param status 유저의 상태(대기자, 유저)
	 * @return
	 */
	private UserChecker createUserChecker(String id, boolean isExist, String status) {
		UserChecker userChecker = new UserChecker();
		userChecker.setId(id);
		userChecker.setExist(isExist);
		userChecker.setStatus(status);
		return userChecker;
	}
	
	public AwaiterService getAwaiterService() {
		return awaiterService;
	}

	public void setAwaiterService(AwaiterService awaiterService) {
		this.awaiterService = awaiterService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

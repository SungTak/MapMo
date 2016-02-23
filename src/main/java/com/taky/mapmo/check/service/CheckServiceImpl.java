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
		UserChecker userChecker = new UserChecker();
		
		Awaiter awaiter = awaiterService.findAwatier(id);
		
		if (awaiter == null) {
			userChecker = this.findUser(id);
		} else {
			userChecker.setId(awaiter.getId());
			userChecker.setExist(true);
			userChecker.setStatus("awaiter");
		}
		
		return userChecker;
	}

	private UserChecker findUser(String id) throws Exception {
		UserChecker userChecker = new UserChecker();
		
		User user = userService.findUser(id);
		
		if (user != null) {
			userChecker.setId(user.getId());
			userChecker.setExist(true);
			userChecker.setStatus("user");
		}
		
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

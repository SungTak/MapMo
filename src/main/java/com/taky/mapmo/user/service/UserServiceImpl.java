package com.taky.mapmo.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taky.mapmo.user.mapper.UserMapper;
import com.taky.mapmo.user.model.User;

/**
 * 
 * @author SeongTak.Yoon
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AwaiterService awaiterService;

	/**
	 * <pre>
	 * rollbackFor : 발생한 Exception에 대해 트랜잭션 롤백 처리(하위 예외 포함)
	 * 
	 * 참고 : http://www.koreajava.com/2014/06/transactional-spring.html
	 * 
	 * 유저 회원가입이 확정되었으니 대기자 목록에서 물리제거한다.
	 * </pre>
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registUser(String id) throws Exception {
		userMapper.insertUser(id);
		awaiterService.removeAwaiter(id);
	}

	@Override
	public User findUser(String id) throws Exception {
		return userMapper.selectUser(id);
	}
	
	@Override
	public User findUser(User user) throws Exception {
		return userMapper.selectUserBy(user);
	}
	
	/**
	 * 로그인을 시도하면 해당 메서드가 호출되어 유저 정보를 찾는다.
	 */
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = null;
		try {
			user = this.findUser(id);
		} catch (Exception e) {
			logger.error("### 유저를 찾는 과정에서 에러가 발생했습니다!", e);
		}
		return user;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public AwaiterService getAwaiterService() {
		return awaiterService;
	}

	public void setAwaiterService(AwaiterService awaiterService) {
		this.awaiterService = awaiterService;
	}
}

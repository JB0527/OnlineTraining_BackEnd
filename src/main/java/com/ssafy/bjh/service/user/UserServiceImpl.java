package com.ssafy.bjh.service.user;

import com.ssafy.bjh.model.dao.user.UserDao;
import com.ssafy.bjh.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.selectLogin(user);
    }

    @Override
    public boolean register(User user) {
        User alreadyUser = userDao.selectUser(user);
        if(alreadyUser != null) {
            return false;
        } else {
            userDao.insertUser(user);
            return true;
        }
    }

	@Override
	@Transactional
	public void subscribe(String userId) {
		userDao.subscribe(userId.split("\"")[1]);
	}
}

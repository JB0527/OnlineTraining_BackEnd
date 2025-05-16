package com.ssafy.bjh.service.user;

import com.ssafy.bjh.model.dao.user.UserDao;
import com.ssafy.bjh.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.selectLogin(user);
    }
}

package com.ssafy.bjh.model.dao.user;

import com.ssafy.bjh.model.dto.User;

public interface UserDao {
    User selectLogin(User user);
}

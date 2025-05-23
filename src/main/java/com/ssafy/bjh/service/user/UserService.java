package com.ssafy.bjh.service.user;

import com.ssafy.bjh.model.dto.User;

public interface UserService {
    User login(User user);
    boolean register(User user);
    void subscribe(String userId);
}

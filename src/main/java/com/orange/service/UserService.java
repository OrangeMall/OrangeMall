package com.orange.service;

import com.orange.vo.User;

public interface UserService {
    public User selectuser(String username,String password);
    public int insertuser(User user);
}

package com.orange.service.impl;

import com.orange.dao.UserDao;
import com.orange.service.UserService;
import com.orange.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public User selectuser(String username, String password) {
        return ud.selectuser(username,password);
    }

    @Override
    public int insertuser(User user) {
        return ud.insertuser(user);
    }
}

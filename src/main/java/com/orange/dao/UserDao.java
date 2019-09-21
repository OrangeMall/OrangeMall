package com.orange.dao;

import com.orange.vo.User;

public interface UserDao {
    public User selectuser(String username,String password);
    public int insertuser(User user);
}

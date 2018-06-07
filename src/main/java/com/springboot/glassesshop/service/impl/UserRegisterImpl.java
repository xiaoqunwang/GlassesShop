package com.springboot.glassesshop.service.impl;

import com.springboot.glassesshop.dao.UserDao;
import com.springboot.glassesshop.model.User;
import com.springboot.glassesshop.service.IUserRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterImpl implements IUserRegister {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public int newUserRegister(User user) {
        int effectRows;
        try{
            effectRows= userDao.newUser(user);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
            return -1;
        }

         return effectRows;
    }
}
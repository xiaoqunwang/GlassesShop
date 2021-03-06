package com.nuoda.glassesshop.service.impl;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.dao.UserDao;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
import com.nuoda.glassesshop.model.User;
import com.nuoda.glassesshop.service.IUserRegister;
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
    @DataSourceTypeAnno(DataSourceEnum.master)
    public int newUserRegister(User user) {
        int effectRows;
        try{
            effectRows= userDao.newUser(user);
        }catch (DuplicateKeyException e){
            return -1;
        }

         return effectRows;
    }
}

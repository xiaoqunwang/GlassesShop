package com.ljl.springboot.demo.service.impl;

import com.ljl.springboot.demo.dao.UserDao;
import com.ljl.springboot.demo.model.User;
import com.ljl.springboot.demo.service.IUserInfoManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoManageImpl implements IUserInfoManage{

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserDao userDao;

    @Override
    public User getUserRegestInfo(String phone) {
        User user = null;
        try{
            user=userDao.getUserRegisterInfoByPhone(phone);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return user;
    }
}

package com.nuoda.glassesshop.service.impl;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
import com.nuoda.glassesshop.service.IUserInfoManage;
import com.nuoda.glassesshop.dao.UserDao;
import com.nuoda.glassesshop.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoManageImpl implements IUserInfoManage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserDao userDao;


    @Override
    @DataSourceTypeAnno(DataSourceEnum.master)
    public User getUserRegestInfo(String phone) {
        User user = null;
        try{
            user=userDao.getUserRegisterInfoByPhone(phone);
            logger.info(user.toString());
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return user;
    }
}

package com.springboot.glassesshop.service;

import com.springboot.glassesshop.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserInfoManage {

   User getUserRegestInfo(String phone);
}

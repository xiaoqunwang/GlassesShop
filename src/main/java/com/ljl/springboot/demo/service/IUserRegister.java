package com.ljl.springboot.demo.service;

import com.ljl.springboot.demo.model.User;
import org.springframework.stereotype.Service;


@Service
public interface IUserRegister {

    public int newUserRegister(User user);
}

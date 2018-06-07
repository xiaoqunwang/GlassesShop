package com.nuoda.glassesshop.service;

import com.nuoda.glassesshop.model.User;
import org.springframework.stereotype.Service;


@Service
public interface IUserRegister {

    public int newUserRegister(User user);
}

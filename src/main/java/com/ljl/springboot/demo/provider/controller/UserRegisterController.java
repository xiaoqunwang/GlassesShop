package com.ljl.springboot.demo.provider.controller;



import com.ljl.springboot.demo.model.User;
import com.ljl.springboot.demo.service.IUserInfoManage;
import com.ljl.springboot.demo.service.IUserRegister;
import com.ljl.springboot.demo.common.ApiResponse;
import com.ljl.springboot.demo.common.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserRegisterController {

    @Qualifier("userRegisterImpl")
    @Autowired
    private IUserRegister userRegister;

    @Qualifier("userInfoManageImpl")
    @Autowired
    private IUserInfoManage userInfoManage;




    @RequestMapping(value = "/register.json",method = RequestMethod.POST)

    public Object register(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String password,
                           @RequestParam(value = "phone")String phone,
                           @RequestParam(value = "email")String email,
                           @RequestParam(value = "openid")String openid){


        try{
            User user=new User();
            user.setName(name);
            user.setPassword(MD5Util.getStringMD5String(password));
            user.setPhone(phone);
            user.setEmail(email);
            user.setOpenid(openid);
            int effectrows=userRegister.newUserRegister(user);
            if(effectrows==-1)
                return ApiResponse.buildFailure("手机号已被注册，请更换号码试试！");
            else return ApiResponse.buildSuccess(user,"注册成功");

        }catch (Exception e){
            return ApiResponse.buildFailure("注册失败");
        }

    }


    @RequestMapping(value = "/userinfo.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getInfoByPhone(
            @RequestParam(value = "phone")String phone
    ){
        try {
            User user = userInfoManage.getUserRegestInfo(phone);
            if (user != null)
                return ApiResponse.buildSuccess(user, "获取用户注册信息成功");
            else
                return ApiResponse.buildFailure("获取用户注册信息失败");
        }catch (Exception e){
            return ApiResponse.buildFailure("获取用户注册信息失败");
        }
    }


}

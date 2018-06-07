package com.nuoda.glassesshop.dao;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
import com.nuoda.glassesshop.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@DataSourceTypeAnno(DataSourceEnum.master)
public interface UserDao {


    @Insert("INSERT " +
            " INTO user(" +
            "name ,"+
            "password ,"+
            "phone ,"+
            "email ,"+
            "openid "+
            " ) " +
            " VALUES(" +
            "#{name},#{password},#{phone},#{email},#{openid}"+
            " )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int newUser(User newuser);


    @Select("SELECT id,name,password,phone,email,openid,create_time,modified_time from user where phone=#{phone} limit 1")
//    @Results(value = { @Result(id = true, column = "id", property = "id"),
//            @Result(column = "name", property = "name"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "phone", property = "phone"),
//            @Result(column = "email", property = "email"),
//            @Result(column = "openid", property = "openid"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "modified_time", property = "modifiedTime")
//    })
    public User getUserRegisterInfoByPhone(String phone);




}

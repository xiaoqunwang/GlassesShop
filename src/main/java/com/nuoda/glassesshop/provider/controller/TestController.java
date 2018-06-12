package com.nuoda.glassesshop.provider.controller;


import com.nuoda.glassesshop.common.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/sayhello.json", method = RequestMethod.GET)

    public Object sayhello(
            @RequestParam(value = "name") String name) {
        try {
            return ApiResponse.buildSuccess("hello"+name,"success");
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.buildFailure(e.getMessage());
        }
    }




}

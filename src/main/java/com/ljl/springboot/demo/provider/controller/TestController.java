package com.ljl.springboot.demo.provider.controller;


import com.ljl.springboot.demo.common.ApiResponse;
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

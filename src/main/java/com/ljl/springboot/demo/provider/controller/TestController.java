package com.ljl.springboot.demo.provider.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljl.springboot.demo.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/sayhello.json", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieList(
            @RequestParam(value = "name") String name) {
        try {
            return ResponseUtil.success("success","hello"+name );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.failed(e.getMessage());
        }
    }


}

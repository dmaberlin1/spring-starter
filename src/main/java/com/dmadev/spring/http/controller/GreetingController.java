package com.dmadev.spring.http.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }

    public ModelAndView bye(ModelAndView modelAndView){
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }


}

package com.dmadev.spring.http.controller;

import com.dmadev.spring.dto.UserReadDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    //    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello/{id}")
    public ModelAndView hello(
            ModelAndView modelAndView,
            HttpServletRequest request,
            @RequestParam("age") Integer age,
            @RequestHeader("accept") String accept,
            @CookieValue("JSESSIONID") String JSESSIONID,
            @PathVariable("id") Integer id
    ) {
//        modelAndView.setViewName("greeting/hello");
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();
        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView helloV2(ModelAndView modelAndView, HttpServletRequest request) {
//        request.getSession().setAttribute(); SessionScope
//        request.setAttribute(); requestScope

        modelAndView.setViewName("greeting/hello");
        modelAndView.addObject("user",new UserReadDto(1L,"Ivan"));
        return modelAndView;
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }


}

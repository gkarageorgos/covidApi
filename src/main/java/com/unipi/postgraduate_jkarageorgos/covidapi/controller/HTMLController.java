package com.unipi.postgraduate_jkarageorgos.covidapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
}
package com.MoneyWhenYouNeed.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/masking")
public class MaskingController {

    @GetMapping
    public String getHelloMessage(){
        return "Hello MoneyWhenYouNeed";
    }


}

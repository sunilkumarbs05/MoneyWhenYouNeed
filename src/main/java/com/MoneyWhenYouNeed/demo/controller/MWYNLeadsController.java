package com.MoneyWhenYouNeed.demo.controller;

import com.MoneyWhenYouNeed.demo.dto.LeadResponseDto;
import com.MoneyWhenYouNeed.demo.service.MWYNLeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MWYNLeadsController {
    @Autowired
    MWYNLeadsService mwynLeadsService;

    @GetMapping(value = "/welcome")
    public String getHelloMessage() {
        return "Hello MoneyWhenYouNeed";
    }

    @GetMapping(value = "/leads")
    public ResponseEntity getLeads(@RequestParam String aid, @RequestParam(name = "site_url") String siteUrl, @RequestParam(name = "first_name") String firstName, @RequestParam(name = "last_name") String lastName, @RequestParam(name = "email") String email, @RequestParam Long dob, @RequestParam Long phone) {
        LeadResponseDto leadResponseDto = mwynLeadsService.getLeads(aid,siteUrl,firstName,lastName,email,dob,phone);
        return ResponseEntity.ok(leadResponseDto);
    }
}

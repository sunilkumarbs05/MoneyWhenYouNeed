package com.MoneyWhenYouNeed.demo.service;

import com.MoneyWhenYouNeed.demo.dto.LeadResponseDto;

public interface MWYNLeadsService {
    LeadResponseDto getLeads(String aid, String siteUrl, String firstName, String lastName, String email, Long dob, Long phone);
}

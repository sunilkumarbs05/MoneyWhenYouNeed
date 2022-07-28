package com.MoneyWhenYouNeed.demo.service;

import com.MoneyWhenYouNeed.demo.dto.LeadResponseDto;

import com.MoneyWhenYouNeed.demo.entity.LoggerEntity;
import com.MoneyWhenYouNeed.demo.repository.LoggerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MWYNLeadsServiceImpl implements MWYNLeadsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MWYNLeadsServiceImpl.class);

    @Value("${mwynl.aid}")
    private String aidMwynl;

    @Value("${mwynl.site_url}")
    private String siteUrlMwynl;

    @Value("${epcvip.url}")
    private String urlEpcvip;

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public LeadResponseDto getLeads(String aid, String siteUrl, String firstName, String lastName, String email, Long dob, Long phone) {

        UriComponentsBuilder builderReq = UriComponentsBuilder.newInstance();
        builderReq.queryParam("aid",aid);
        builderReq.queryParam("site_url", siteUrl);
        builderReq.queryParam("first_name",firstName);
        builderReq.queryParam("last_name",lastName);
        builderReq.queryParam("email",email);
        builderReq.queryParam("dob",dob);
        builderReq.queryParam("phone",phone);

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder. fromUriString(urlEpcvip);
        builder.queryParam("aid",aidMwynl);
        builder.queryParam("site_url", siteUrlMwynl);
        builder.queryParam("first_name",firstName);
        builder.queryParam("last_name",lastName);
        builder.queryParam("email",email);
        builder.queryParam("dob",dob);
        builder.queryParam("phone",phone);

        String url = builder.build().toString();
        LeadResponseDto leadResponseDto = null;
        try {
             leadResponseDto = restTemplate.getForObject(builder.build().toString(), LeadResponseDto.class);
        } catch (Exception e){
            LOGGER.info("error "+e.getStackTrace());
        }

        LoggerEntity loggerEntity = new LoggerEntity();
        loggerEntity.setRequestMwyn(builderReq.toUriString());
        loggerEntity.setResponseMwyn(leadResponseDto.toString());
        loggerEntity.setRequestEpciv(builder.toUriString());
        loggerEntity.setResponseEpciv(leadResponseDto.toString());
        loggerRepository.save(loggerEntity);

        return leadResponseDto;
    }
}

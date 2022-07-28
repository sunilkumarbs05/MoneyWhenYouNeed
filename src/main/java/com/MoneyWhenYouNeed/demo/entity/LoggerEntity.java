package com.MoneyWhenYouNeed.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "logger")
public class LoggerEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "request_mwyn")
    private String requestMwyn;
    @Column(name = "response_mwyn")
    private String responseMwyn;
    @Column(name = "request_epciv")
    private String requestEpciv;
    @Column(name = "response_epciv")
    private String responseEpciv;

}

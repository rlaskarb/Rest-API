package com.ohgiraffers.testapi.model.dto;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Message {

    private int code;
    private String message;
    private Map<String,Object> result;


}

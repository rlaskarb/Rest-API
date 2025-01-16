package com.ohgiraffers.restapi.section01.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    private int httpStatusCode; //http 상세코드
    private String message; // 메시지

}

package com.project.veganpleasure.global.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    private String accessToken;
    private Long expireTime;
}

package com.project.veganpleasure.domain.member.controller;

import com.project.veganpleasure.domain.member.repository.MemberRepository;
import com.project.veganpleasure.domain.member.request.MemberLoginRequest;
import com.project.veganpleasure.domain.member.response.MemberLoginResponse;
import com.project.veganpleasure.domain.member.service.MemberService;
import com.project.veganpleasure.global.jwt.dto.AccessToken;
import com.project.veganpleasure.global.jwt.exception.TokenIsInvalidException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("v1/api/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @ApiOperation("로그인")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public MemberLoginResponse login(@RequestBody MemberLoginRequest memberLoginRequest){
        return memberService.login(memberLoginRequest);
    }

    @ApiOperation("엑세스 토큰 재발급")
    @GetMapping("/accesstoken")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessToken requestAccessToken(@RequestHeader String refreshToken) throws TokenIsInvalidException {
        return memberService.getAccessTokenBy(refreshToken);
    }
}

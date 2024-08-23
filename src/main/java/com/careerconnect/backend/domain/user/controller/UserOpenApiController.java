package com.careerconnect.backend.domain.user.controller;

import com.careerconnect.backend.common.api.Api;
import com.careerconnect.backend.domain.user.business.UserBusiness;
import com.careerconnect.backend.domain.user.dto.UserLoginRequest;
import com.careerconnect.backend.domain.user.dto.UserRegisterRequest;
import com.careerconnect.backend.domain.user.dto.UserResponse;
import com.careerconnect.backend.domain.user.service.UserService;
import com.careerconnect.backend.domain.user.token.controller.model.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="POST")
public class UserOpenApiController {

    private final UserService userService;
    private final UserBusiness userBusiness;


    // 회원가입
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ) {

        var response = userBusiness.register(request.getBody());
        return Api.OK(response);
    }

    // 로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
            @Valid
            @RequestBody Api<UserLoginRequest> request
    ){
        var response = userBusiness.login(request.getBody());
        return Api.OK(response);
    }
}

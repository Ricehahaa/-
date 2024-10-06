package com.heima.admin.controller.v1;

import com.heima.admin.service.AdUserService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AdUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
@Api(value = "管理端端用户登录",tags = "管理端端用户登录")
public class AdUserLoginController {

    @Autowired
    private AdUserService adUserService;

    @PostMapping("/in")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody AdUserDto dto){
        return adUserService.login(dto);
    }
}

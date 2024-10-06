package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AdUserDto;
import com.heima.model.user.pojos.AdUser;

public interface AdUserService extends IService<AdUser> {
    /**
     * app端登录功能
     * @param dto
     * @return
     */
    public ResponseResult login(AdUserDto dto);
}

package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.user.pojos.ApUserFan;

public interface ApUserFanService extends IService<ApUserFan> {

    Boolean isFollow(Integer userId, Integer fanId);
}

package com.heima.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.user.pojos.ApUserFan;
import com.heima.user.mapper.ApUserFanMapper;
import com.heima.user.service.ApUserFanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class ApUserFanServiceImpl extends ServiceImpl<ApUserFanMapper, ApUserFan> implements ApUserFanService {

    @Override
    public Boolean isFollow(Integer userId, Integer fanId) {
        ApUserFan one = getOne(Wrappers.<ApUserFan>lambdaQuery()
                .eq(ApUserFan::getUserId, userId)
                .eq(ApUserFan::getFansId, fanId));

        return one != null;
    }
}

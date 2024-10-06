package com.heima.user.feign;

import com.heima.user.service.ApUserFanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClient {

    @Autowired
    private ApUserFanService apUserFanService;

    @PostMapping("/api/v1/isFollow/{userId}/{fanId}")
    public Boolean isFollow(@PathVariable Integer userId, @PathVariable Integer fanId){
        return apUserFanService.isFollow(userId,fanId);
    }
}

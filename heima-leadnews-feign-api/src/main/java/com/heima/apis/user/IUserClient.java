package com.heima.apis.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("leadnews-user")
public interface IUserClient {

    /**
     * 判断是否关注
     * @param userId
     * @param fanId
     * @return
     */
    @PostMapping("/api/v1/isFollow/{userId}/{fanId}")
    public Boolean isFollow(@PathVariable Integer userId, @PathVariable Integer fanId);

}
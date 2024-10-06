package com.heima.apis.wemedia;

import com.heima.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("leadnews-wemedia")
public interface IWemediaClient {


    @GetMapping("/api/v1/get-wmuser/{id}")
    public ResponseResult getWmUser(@PathVariable Integer id);



    @GetMapping("/api/v1/get-wmuser2/{id}")
    public ResponseResult getWmUserByUserId(@PathVariable Integer id);

    @GetMapping("/api/v1/channel/list")
    public ResponseResult getChannels();

}
package com.heima.wemedia.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.pojos.WmUser;
import com.heima.wemedia.service.WmChannelService;
import com.heima.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WemediaClient {

    @Autowired
    WmUserService wmUserService;

    /**
     * 通过id查询对应的WmUser
     * @param id
     * @return
     */
    @GetMapping("/api/v1/get-wmuser/{id}")
    public ResponseResult getWmUser(@PathVariable Integer id) {
        return ResponseResult.okResult(wmUserService.getById(id));
    }

    /**
     * 通过apuserid查询对应的WmUser
     * @param id
     * @return
     */
    @GetMapping("/api/v1/get-wmuser2/{id}")
    public ResponseResult getWmUserByUserId(@PathVariable Integer id) {
        return ResponseResult.okResult(wmUserService.getOne(Wrappers.<WmUser>query().eq("ap_user_id", id)));
    }

    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/api/v1/channel/list")
    public ResponseResult getChannels() {
        return wmChannelService.findAll();
    }

}
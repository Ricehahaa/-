package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.AdChannel;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {
    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/channels")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }

    /**
     * 根据条件查询频道
     * @param channelDto
     * @return
     */
    @PostMapping("/list")
    public ResponseResult listByName(@RequestBody ChannelDto channelDto){
        return wmChannelService.listByName(channelDto);
    }

    @GetMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable Integer id){
        return wmChannelService.deleteById(id);
    }


    @PostMapping("/save")
    public ResponseResult saveNewChannel(@RequestBody AdChannel adChannel){
        return wmChannelService.saveNewChannel(adChannel);
    }


    @PostMapping("/update")
    public ResponseResult updateChannel(@RequestBody AdChannel adChannel){
        return wmChannelService.updateChannel(adChannel);
    }
}
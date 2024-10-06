package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.AdChannel;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();


    /**
     * 根据条件查询频道
     * @param channelDto
     * @return
     */
    ResponseResult listByName(ChannelDto channelDto);

    /**
     * 根据id删除频道
     * @param id
     * @return
     */
    ResponseResult deleteById(Integer id);

    ResponseResult saveNewChannel(AdChannel adChannel);

    ResponseResult updateChannel(AdChannel adChannel);
}
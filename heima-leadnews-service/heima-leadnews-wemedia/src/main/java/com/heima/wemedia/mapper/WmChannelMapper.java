package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.dtos.AdChannel;
import com.heima.model.wemedia.pojos.WmChannel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WmChannelMapper extends BaseMapper<WmChannel> {


    /**
     * 动态sql更新频道
     * @param adChannel
     */
    void updateByCondition(AdChannel adChannel);
}
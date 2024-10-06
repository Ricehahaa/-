package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.AdChannel;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.model.wemedia.pojos.WmNews;
import com.heima.wemedia.mapper.WmChannelMapper;
import com.heima.wemedia.service.WmChannelService;
import com.heima.wemedia.service.WmNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements WmChannelService {


    /**
     * 查询所有频道
     * @return
     */
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(list());
    }

    @Override
    public ResponseResult listByName(ChannelDto channelDto) {
        //1.检查参数
        channelDto.checkParam();

        //2.分页查询
        IPage page = new Page(channelDto.getPage(),channelDto.getSize());
        LambdaQueryWrapper<WmChannel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //按照频道名称查询,没有就全查
        if(channelDto.getName() != null && !channelDto.getName().isEmpty()){
            lambdaQueryWrapper.eq(WmChannel::getName, channelDto.getName());
        }

        //按照ord排序
        lambdaQueryWrapper.orderByAsc(WmChannel::getOrd);


        page = page(page,lambdaQueryWrapper);

        //3.结果返回
//        ResponseResult responseResult = new PageResponseResult(channelDto.getPage(),channelDto.getSize(),(int)page.getTotal());
//        responseResult.setData(page.getRecords());


        return ResponseResult.okResult(page.getRecords());
    }

    @Autowired
    WmNewsService wmNewsService;

    @Override
    public ResponseResult deleteById(Integer id) {
        // 判断一下是否存在这个频道id
        int sum = count(Wrappers.<WmChannel>query().eq("id", id));
        if(sum == 0){
            return ResponseResult.errorResult(AppHttpCodeEnum.CHANNEL_NON_EXISTENT);
        }
        //判断是否有文章是这个频道的
        sum = wmNewsService.count(Wrappers.<WmNews>query().eq("channel_id", id));
        if(sum != 0){
            return ResponseResult.errorResult(AppHttpCodeEnum.CHANNEL_REFERENCED);
        }
        removeById(id);
        return ResponseResult.okResult(null);
    }

    @Override
    public ResponseResult saveNewChannel(AdChannel adChannel) {
        //判断频道名称为空
        if(adChannel.getName() == null || adChannel.getName().isEmpty()){
            return ResponseResult.errorResult(AppHttpCodeEnum.CHANNEL_NAME_EMPTY);
        }
        adChannel.setCreatedTime(new Date());
        adChannel.setIsDefault(true);
        if(adChannel.getOrd() == null){
            adChannel.setOrd(0);
        }
        WmChannel wmChannel = new WmChannel();
        BeanUtils.copyProperties(adChannel, wmChannel);
        save(wmChannel);
        return ResponseResult.okResult(null);
    }

    @Autowired
    WmChannelMapper wmChannelMapper;
    @Override
    public ResponseResult updateChannel(AdChannel adChannel) {
        //判断频道名称为空
        if(adChannel.getName() == null || adChannel.getName().isEmpty()){
            return ResponseResult.errorResult(AppHttpCodeEnum.CHANNEL_NAME_EMPTY);
        }
        wmChannelMapper.updateByCondition(adChannel);
        return ResponseResult.okResult(null);
    }
}
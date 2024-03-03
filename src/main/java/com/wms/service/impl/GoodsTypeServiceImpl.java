package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.entity.GoodsType;
import com.wms.mapper.GoodsTypeMapper;
import com.wms.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public IPage<GoodsType> pageCC(IPage<GoodsType> page, Wrapper wrapper) {
        return goodsTypeMapper.pageCC(page,wrapper);
    }

}

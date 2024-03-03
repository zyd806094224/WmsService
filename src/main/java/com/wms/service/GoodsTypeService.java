package com.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.GoodsType;

public interface GoodsTypeService extends IService<GoodsType> {

    IPage<GoodsType> pageCC(IPage<GoodsType> page, Wrapper wrapper);
}

package com.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.Goods;

public interface GoodsService extends IService<Goods> {

    IPage<Goods> pageCC(IPage<Goods> page, Wrapper wrapper);
}

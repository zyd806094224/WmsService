package com.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.Storage;

public interface StorageService extends IService<Storage> {

    IPage<Storage> pageCC(IPage<Storage> page, Wrapper wrapper);
}

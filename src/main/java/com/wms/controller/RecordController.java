package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.Goods;
import com.wms.entity.Record;
import com.wms.service.GoodsService;
import com.wms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String storage = (String) param.get("storage");
        String goodsType = (String) param.get("goodsType");
        String userId = (String) param.get("userId");
        String roleId = (String) param.get("roleId");

        Page<Record> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        QueryWrapper<Record> queryWrapper = new QueryWrapper();
        queryWrapper.apply(" a.goods=b.id and b.storage=c.id and b.goodsType=d.id ");//拼接sql

        if("2".equals(roleId)){ //普通用户 只能查看自己的操作记录
            queryWrapper.apply(" a.userid= " + userId);
        }
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            queryWrapper.like("b.name", name);
        }
        if (StringUtils.isNotBlank(storage) && !"null".equals(storage)) {
            queryWrapper.eq("c.id", storage);
        }
        if (StringUtils.isNotBlank(goodsType) && !"null".equals(goodsType)) {
            queryWrapper.eq("d.id", goodsType);
        }

        IPage result = recordService.pageCC(page, queryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/save")
    public Result save(@RequestBody Record record) {
        Goods goods = goodsService.getById(record.getGoods());
        int num = record.getCount();
        if ("2".equals(record.getAction())) {
            num = -num;
            record.setCount(num);
        } else if ("3".equals(record.getAction())) { //新增物品或者修改已有物品的记录 数量直接覆盖
            goods.setCount(record.getCount());
            goodsService.updateById(goods);
            return recordService.save(record) ? Result.success() : Result.fail();
        }
        int resNum = goods.getCount() + num;
        goods.setCount(resNum);
        goodsService.updateById(goods);
        return recordService.save(record) ? Result.success() : Result.fail();
    }
}

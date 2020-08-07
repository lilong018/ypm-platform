package com.platform.modules.feerecord.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;

import com.platform.modules.feerecord.dao.FeerecordDao;
import com.platform.modules.feerecord.entity.FeerecordEntity;
import com.platform.modules.feerecord.service.FeerecordService;


@Service("feerecordService")
public class FeerecordServiceImpl extends ServiceImpl<FeerecordDao, FeerecordEntity> implements FeerecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeerecordEntity> page = this.page(
                new Query<FeerecordEntity>().getPage(params),
                new QueryWrapper<FeerecordEntity>()
        );

        return new PageUtils(page);
    }

}

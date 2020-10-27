package com.platform.modules.bank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;
import com.platform.modules.bank.dao.BankDao;
import com.platform.modules.bank.entity.BankEntity;
import com.platform.modules.bank.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("bankService")
public class BankServiceImpl extends ServiceImpl<BankDao, BankEntity> implements BankService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BankEntity> page = this.page(
                new Query<BankEntity>().getPage(params),
                new QueryWrapper<BankEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<BankEntity> getByEnterpriseId(String id) {
        return null;
    }

}

package com.platform.modules.enterprise.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;

import com.platform.modules.enterprise.dao.EnterpriseDao;
import com.platform.modules.enterprise.entity.EnterpriseEntity;
import com.platform.modules.enterprise.service.EnterpriseService;


@Service("enterpriseService")
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseDao, EnterpriseEntity> implements EnterpriseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EnterpriseEntity> page = this.page(
                new Query<EnterpriseEntity>().getPage(params),
                new QueryWrapper<EnterpriseEntity>()
        );

        return new PageUtils(page);
    }

}

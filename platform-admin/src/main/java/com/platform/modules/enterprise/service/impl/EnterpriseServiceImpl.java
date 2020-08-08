package com.platform.modules.enterprise.service.impl;

import com.platform.modules.platform.entity.PlatformEntity;
import org.apache.commons.lang.StringUtils;
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
        String name = (String) params.get("name");
        String useraccount = (String) params.get("useraccount");
        String status = (String) params.get("status");
        String customer = (String) params.get("customer");
        // TODO: 2020/8/8 添加客服id的查询条件
        if(name != null) {
            name = name.trim();
        }
        if(useraccount != null) {
            useraccount = useraccount.trim();
        }
        if(status != null) {
            status = status.trim();
        }
        QueryWrapper<EnterpriseEntity> queryWrapper = new QueryWrapper<EnterpriseEntity>();
        queryWrapper.like(StringUtils.isNotBlank(name), EnterpriseEntity.FIELD_NAME, name);
        queryWrapper.like(StringUtils.isNotBlank(useraccount), EnterpriseEntity.FIELD_ACCOUNT, useraccount);
        queryWrapper.eq(StringUtils.isNotBlank(status), EnterpriseEntity.FIELD_STATUS, status);
        IPage<EnterpriseEntity> page = this.page(new Query<EnterpriseEntity>().getPage(params),queryWrapper);

        return new PageUtils(page);
    }

}

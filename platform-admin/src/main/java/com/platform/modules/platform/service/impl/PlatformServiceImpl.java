package com.platform.modules.platform.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;

import com.platform.modules.platform.dao.PlatformDao;
import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.service.PlatformService;


@Service("platformService")
public class PlatformServiceImpl extends ServiceImpl<PlatformDao, PlatformEntity> implements PlatformService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        if(name != null) {
            name = name.trim();
        }
        QueryWrapper<PlatformEntity> queryWrapper = new QueryWrapper<PlatformEntity>();
        queryWrapper.like(StringUtils.isNotBlank(name), PlatformEntity.FIELD_NAME, name);
        IPage<PlatformEntity> page = this.page(new Query<PlatformEntity>().getPage(params),queryWrapper);

        return new PageUtils(page);
    }

}

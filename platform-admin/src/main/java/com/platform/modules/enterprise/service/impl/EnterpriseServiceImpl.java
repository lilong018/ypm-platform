package com.platform.modules.enterprise.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.modules.enterprise.entity.*;
import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.entity.PlatformRespond;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.platform.modules.enterprise.dao.EnterpriseDao;
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

    @Override
    public PageUtils selectPages(Map<String, Object> params) {
        Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        Map<String, String> urlParams = ParamsUtils.convertParams(params);
        // TODO: 2020/9/18 platformId 通过客服/用户获取
        urlParams.put("platformId","5f5b406e6c1b726ef76c15fb");

        String name = (String) params.get("name");
        if (StringUtil.isNotEmpty(name)){
            urlParams.put("name",name);
        }
        String account = (String) params.get("account");
        if (StringUtil.isNotEmpty(account)){
            urlParams.put("account",account);
        }
        String status = (String) params.get("status");
        if (StringUtil.isNotEmpty(status)){
            urlParams.put("status",status);
        }
        String customer = (String) params.get("customer");
        if (StringUtil.isNotEmpty(customer)){
            urlParams.put("employeeName",customer);
        }
        Map<String, String> headerMap = new HashMap<String, String>();

        headerMap.put("x-auth-token", AuthService.getToken("11111111111","admin",false));
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.ENTERPRISE, headerMap, urlParams, null);
            System.out.println(res);
            EnterpriseRespond respond = JSON.parseObject(res, EnterpriseRespond.class);
            if (respond.getStatusCode() == 0){
                EnterprisePayload payload = respond.getPayload();
                List<EnterpriseResults> results = payload.getResults();
                List<EnteroriseVo> vos = new ArrayList<EnteroriseVo>();
                results.forEach(enterpriseResult ->{
                    EnteroriseVo enteroriseVo = new EnteroriseVo(enterpriseResult.getCompanyInfo());
                    enteroriseVo.setPlatformId(enterpriseResult.getPlatform().getId());
                    vos.add(enteroriseVo);
                });
                page = new PageUtils(vos, payload.getTotal(), pageSize, pageNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

}

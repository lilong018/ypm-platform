package com.platform.modules.bill.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.modules.bill.entity.BankListVo;
import com.platform.modules.bill.entity.BillResults;
import com.platform.modules.enterprise.entity.EnteroriseVo;
import com.platform.modules.response.CommonPageResults;
import com.platform.modules.response.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.platform.modules.bill.dao.BillDao;
import com.platform.modules.bill.entity.BillEntity;
import com.platform.modules.bill.service.BillService;


@Service("billService")
public class BillServiceImpl extends ServiceImpl<BillDao, BillEntity> implements BillService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BillEntity> page = this.page(
                new Query<BillEntity>().getPage(params),
                new QueryWrapper<BillEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectPages(Map<String, Object> params) {
        PageUtils page = null;
        Integer pageNumber = 1;
        Integer pageSize = 10;
        if (params.get("page")!=null){
            pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        }
        if (params.get("limit")!=null){
            pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        }
        //参数
        Map<String, String> urlParams = ParamsUtils.convertParams(params);
        Map<String, String> headerMap = new HashMap<>();
        //header
        headerMap.put("x-auth-token", AuthService.getToken());
        String res = null;
        CommonResponse<CommonPageResults<BillResults>> commonResponse = null;
        try {
            res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.BILLS, headerMap, urlParams, null);
            System.out.println(res);
            commonResponse = JSON.parseObject(res, new TypeReference<CommonResponse<CommonPageResults<BillResults>>>() {
            });
            if (commonResponse != null && commonResponse.getStatusCode() == 0){
                List<BankListVo> vos = new ArrayList<BankListVo>();
                CommonPageResults<BillResults> payload = commonResponse.getPayload();
                page = new PageUtils(vos, payload.getTotal(), pageSize, pageNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }


}

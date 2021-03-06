package com.platform.modules.enterprise.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.modules.employee.entity.Platform;
import com.platform.modules.enterprise.dao.EnterpriseDao;
import com.platform.modules.enterprise.entity.*;
import com.platform.modules.enterprise.service.EnterpriseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Integer pageNumber = 1;
        Integer pageSize = 10;
        if (StringUtil.isNotEmpty(String.valueOf(params.get("page")))){
            pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        }
        if (StringUtil.isNotEmpty(String.valueOf(params.get("limit")))){
            pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        }
        Map<String, String> urlParams = ParamsUtils.convertParams(params);
        // TODO: 2020/9/18 platformId 通过客服/用户获取
        urlParams.put("platformId",AuthService.getPlatformId());

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
        Map<String, String> headerMap = new HashMap<>();

        headerMap.put("x-auth-token", AuthService.getToken());
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.ENTERPRISE, headerMap, urlParams, null);
            System.err.println(res);
            EnterpriseRespond respond = JSON.parseObject(res, EnterpriseRespond.class);
            if (respond.getStatusCode() == 0){
                EnterprisePayload payload = respond.getPayload();
                List<EnterpriseResults> results = payload.getResults();
                List<EnteroriseVo> vos = new ArrayList<EnteroriseVo>();
                StringBuffer sb = new StringBuffer();
                results.forEach(enterpriseResult ->{
                    EnteroriseVo vo = new EnteroriseVo();
                    vo.setId(enterpriseResult.getId());
                    Platform platform = enterpriseResult.getPlatform();
                    List<Channels> channels = enterpriseResult.getChannels();
                    channels.forEach(channel -> {
                        if (channel.getType() == 1){
                            sb.append("京东智票、");
                        }if (channel.getType() == 2){
                            sb.append("京东智付、");
                        }
                        //看是买方还是卖方
                        Map<String, BankInfo> banks = channel.getBanks();
                        banks.forEach((str,bank)->{
                            //查找注册来源为企业实名认证的银行
                            if (bank.getSource() == 1){
                                Handler handler = bank.getHandler();
                                if(handler != null){
                                    vo.setHandlerId(handler.getId());
                                    vo.setHandlerName(handler.getName());
                                }
                                vo.setStatus(bank.getApplyStatus());
                                int bankType = bank.getType();
                                if (bankType == 1){
                                    vo.setRoleName("卖方");
                                }else if (bankType == 2){
                                    vo.setRoleName("买方");
                                }
                                Map<String, ApplyStatus> applyStatusHistory = bank.getApplyStatusHistory();
                                applyStatusHistory.forEach((timeId,applyStatus)->{
                                    if (applyStatus.getApplyStatus()==1){
                                        vo.setCreatetime(applyStatus.getTime());
                                    }
                                });
                            }
                        });
                    });
                    String channelName = sb.toString();
                    channelName = channelName.substring(0,channelName.length()-1);
                    CompanyInfo companyInfo = enterpriseResult.getCompanyInfo();
                    vo.setAccount(enterpriseResult.getAccount());
                    vo.setName(companyInfo.getName());
                    vo.setChannelName(channelName);
                    vo.setPlatformId(platform.getId());
                    vo.setPlatformName(platform.getName());
                    //清空sb
                    sb.delete(0, sb.length()-1);
                    vos.add(vo);
                });
                page = new PageUtils(vos, payload.getTotal(), pageSize, pageNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @Override
    public boolean accept(String id) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-auth-token", AuthService.getToken());
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("channelType","1");
        String address = UrlConstans.BASEURL+UrlConstans.ENTERPRISE+"/"+id+"/accept";
        try {
            String res = HttpUtil.put(address, headerMap, urlParams, null);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public EnterpriseInfoVo findById(String id){
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-auth-token", AuthService.getToken());
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("platformId",AuthService.getPlatformId());
        urlParams.put("enterpriseId",id);
        urlParams.put("start","0");
        urlParams.put("count","1");
        EnterpriseInfoVo enterpriseInfoVo = null;
        String res = null;
        try {
            res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.ENTERPRISE, headerMap, urlParams, null);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EnterpriseRespond respond = JSON.parseObject(res, EnterpriseRespond.class);
        EnterprisePayload payload = respond.getPayload();
        EnterpriseResults enterpriseResults = payload.getResults().get(0);

        if (enterpriseResults!=null){
            enterpriseInfoVo = new EnterpriseInfoVo(enterpriseResults);
        }else{
            return null;
        }
        return enterpriseInfoVo;
    }

    @Override
    public void review(ReviewEntity enteroriseRevie) {
        Map<String, String> headerMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        headerMap.put("x-auth-token", AuthService.getToken());
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("channelType","1");
        params.put("result",enteroriseRevie.getStatus());
        List<String> reason = new ArrayList<>();
        params.put("reason",reason);
        params.put("comment","测试备注功能！");

        String address = UrlConstans.BASEURL +UrlConstans.ENTERPRISE +"/" + enteroriseRevie.getId()+"/audit";

        try {
            String res = HttpUtil.put(address, headerMap, urlParams, JSON.toJSONString(params));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
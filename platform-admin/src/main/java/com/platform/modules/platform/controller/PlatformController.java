package com.platform.modules.platform.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.entity.PlatformRespond;
import com.platform.modules.platform.entity.PlatformResults;
import com.platform.modules.platform.service.PlatformService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ll
 * @email
 * @date 2020-08-05 11:33:42
 */
@RestController
@RequestMapping("platform/platform")
public class PlatformController {
    @Autowired
    private PlatformService platformService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("platform:platform:list")
    public R list(@RequestParam Map<String, Object> params) {

        Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));

        Map<String, String> headerMap = new HashMap<String, String>();
        Map<String, String> urlParams = convertParams(params);
        headerMap.put("x-auth-token", AuthService.getAuth());
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.PLATFORM, headerMap, urlParams, null);
            System.out.println(res);
            PlatformRespond platformRespond = JSON.parseObject(res, PlatformRespond.class);
            page = new PageUtils(platformRespond.getPayload().getResults(), platformRespond.getPayload().getTotal(), pageSize, pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("platform:platform:info")
    public R info(@PathVariable("id") String id) {
        // TODO: 2020/9/10 將header中的
        //在header中添加token
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getAuth());
        //设置参数
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("start", "0");
        urlParams.put("count", "1");
        urlParams.put("platformId", id);
        PlatformResults platformResults = new PlatformResults();
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.PLATFORM, headerMap, urlParams, null);
            System.out.println(res);
            PlatformRespond platformRespond = JSON.parseObject(res, PlatformRespond.class);
            platformResults  = platformRespond.getPayload().getResults().get(0);
//            page = new PageUtils(platformRespond.getPayload().getResults(), platformRespond.getPayload().getTotal(), pageSize, pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok().put("platform", platformResults);
    }


    /**
     * @param platform
     * @Description 新增平台
     * @Return com.platform.common.utils.R
     * @Author lilong
     * @Date 2020/9/9 9:55
     **/
    @RequestMapping("/save")
    @RequiresPermissions("platform:platform:save")
    public R save(@RequestBody PlatformEntity platform) {

        Map<String, String> headerMap = new HashMap<String, String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", platform.getName());
        params.put("website", platform.getWebsite());
        params.put("manager", platform.getManager());
        params.put("phoneNo", platform.getPhoneno());
        params.put("bonusPercentage", platform.getBonusPercentage());
        headerMap.put("x-auth-token", AuthService.getAuth());
        String res = null;
        try {
            String address = UrlConstans.BASEURL + UrlConstans.PLATFORM;
            res = HttpUtil.post(address, headerMap, JSON.toJSONString(params));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("新增平台返回值：---->>>>" + res);
//        PlatformResponseBody platformResponseBody = JSONObject.parseObject(res, PlatformResponseBody.class);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("platform:platform:update")
    public R update(@RequestBody PlatformEntity platform) {
        ValidatorUtils.validateEntity(platform);
        platformService.updateById(platform);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("platform:platform:delete")
    public R delete(@RequestBody String[] ids) {
        platformService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * @param params
     * @Description 转换参数
     * @Return
     * @Throws Exception
     * @Author lilong
     * @Date 2020/9/10 16:55
     **/
    private Map<String, String> convertParams(Map<String, Object> params) {
        // TODO: 2020/9/10  判断参数是否为空 添加其他相关参数
        Map<String, String> urlParams = new HashMap<String, String>();
        Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        Integer start = (pageNumber - 1) * pageSize;
        urlParams.put("start", String.valueOf(start));
        urlParams.put("count", String.valueOf(pageSize));
        return urlParams;

    }

}

package com.platform.modules.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.AuthService;
import com.platform.common.utils.HttpUtil;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.entity.PlatformRespond;
import com.platform.modules.platform.entity.PlatformResults;
import com.platform.modules.platform.service.PlatformService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
        headerMap.put("x-auth-token", AuthService.getToken());
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.PLATFORM, headerMap, urlParams, null);
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
        headerMap.put("x-auth-token", AuthService.getToken());
        //设置参数
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("start", "0");
        urlParams.put("count", "1");
        urlParams.put("platformId", id);
        PlatformResults platformResults = new PlatformResults();
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.PLATFORM, headerMap, urlParams, null);
            PlatformRespond platformRespond = JSON.parseObject(res, PlatformRespond.class);
            platformResults = platformRespond.getPayload().getResults().get(0);
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
        Map<String, Object> params = getParamsBody(platform);
        headerMap.put("x-auth-token", AuthService.getToken());
        String res = null;
        try {
            //添加平台
            String address = UrlConstans.BASEURL + UrlConstans.PLATFORM;
            res = HttpUtil.post(address, headerMap, JSON.toJSONString(params));
            Map<String, Object> respond = JSONObject.parseObject(res, new TypeReference<Map<String, Object>>() {});
            Map<String, String> payload = (Map<String, String>) respond.get("payload");
            String platformId = payload.get("platformId");

            //添加平台管理者账户
            Map<String, Object> userParams = new HashMap<String, Object>();
            Map<String, Object> employeeMap = new HashMap<String, Object>();
            employeeMap.put("name",platform.getName());
            employeeMap.put("department",3);
            employeeMap.put("phoneNo",platform.getPhoneNo());

            List<String> controlPlatform = new ArrayList<String>();
            controlPlatform.add(platformId);

            Map<String, Object> userMap = new HashMap<String, Object>();
            userMap.put("account",platform.getPhoneNo());
            userMap.put("password","admin");
            userMap.put("isFirstLoginReset",true);
            userMap.put("isNotAllowReset",false);
            userMap.put("isPlatformAdmin",false);
            userMap.put("controlPlatform",controlPlatform);
            userParams.put("employee",employeeMap);
            userParams.put("platformId",platformId);
            userParams.put("user",userMap);

            String userRes = HttpUtil.post(UrlConstans.BASEURL + UrlConstans.EMPLOYEES, headerMap, JSON.toJSONString(userParams));
            System.out.println(userRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getToken());
        Map<String, Object> params = getParamsBody(platform);
        String res = null;
        try {
            String address = UrlConstans.BASEURL + UrlConstans.PLATFORM + "/" + platform.getId();
            res = HttpUtil.put(address, headerMap, JSON.toJSONString(params));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }


        platformService.updateById(platform);
        return R.ok();
    }

    private Map<String, Object> getParamsBody(@RequestBody PlatformEntity platform) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", platform.getName());
        params.put("website", platform.getWebsite());
        params.put("manager", platform.getManager());
        params.put("phoneNo", platform.getPhoneNo());
        params.put("bonusPercentage", platform.getBonusPercentage());
        return params;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("platform:platform:delete")
    public R delete(@RequestBody String[] ids) {
        String address = UrlConstans.BASEURL + UrlConstans.PLATFORM +"/";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getToken());
        List<String> idList = Arrays.asList(ids);
        for (String id : ids) {
            address += id;
            try {
                String res = HttpUtil.delete(address, headerMap, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
//        urlParams.put("valid", "true");
        return urlParams;

    }

}

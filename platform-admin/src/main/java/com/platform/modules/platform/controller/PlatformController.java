package com.platform.modules.platform.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.service.PlatformService;


/**
 * 
 *
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
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = platformService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("platform:platform:info")
    public R info(@PathVariable("id") String id){
        PlatformEntity platform = platformService.getById(id);

        return R.ok().put("platform", platform);
    }


    /**
     * @Description 新增平台
     * @param platform
     * @Return com.platform.common.utils.R
     * @Author lilong
     * @Date 2020/9/9 9:55
     **/
    @RequestMapping("/save")
    @RequiresPermissions("platform:platform:save")
    public R save(@RequestBody PlatformEntity platform){
        /*String id = SnowFlakeUtils.nextId()+"";
        platform.setId(id);
        platform.setCreatetimeinmillis(new Date());
        platformService.save(platform);*/

        Map<String,Object> headerMap = new HashMap<String,Object>();
//        if (StringUtil.isNotEmpty(platformId)){
//            headerMap.put("platformId", platformId);
//        }
//        if (StringUtil.isNotEmpty(website)){
//            headerMap.put("website", website);
//        }
        Map<String,Object> params = new HashMap<String,Object>();
//        {
//            "name": "String", // 顯示名稱
//                "website": "String", // 網域名稱
//                "manager": "String", // 負責人
//                "phoneNo": "String", // 聯絡電話
//                "bonusPercentage": "integer" // 分紅百分比
//        }
        params.put("name",platform.getName());
        params.put("website",platform.getWebsite());
        params.put("manager",platform.getManager());
        params.put("phoneNo",platform.getPhoneno());
        params.put("bonusPercentage",platform.getBonusPercentage());
        headerMap.put("x-auth-token","");
        String res = HttpUtils.doGet(UrlConstans.PLATFORM, params, headerMap);
//        PlatformResponseBody platformResponseBody = JSONObject.parseObject(res, PlatformResponseBody.class);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("platform:platform:update")
    public R update(@RequestBody PlatformEntity platform){
        ValidatorUtils.validateEntity(platform);
        platformService.updateById(platform);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("platform:platform:delete")
    public R delete(@RequestBody String[] ids){
        platformService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

package com.platform.modules.platform.controller;

import com.alibaba.fastjson.JSON;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.HttpUtil;
import com.platform.common.utils.HttpUtils;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.service.PlatformService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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

        Map<String,String> headerMap = new HashMap<String,String>();
//        if (StringUtil.isNotEmpty(platformId)){
//            headerMap.put("platformId", platformId);
//        }
//        if (StringUtil.isNotEmpty(website)){
//            headerMap.put("website", website);
//        }
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name",platform.getName());
        params.put("website",platform.getWebsite());
        params.put("manager",platform.getManager());
        params.put("phoneNo",platform.getPhoneno());
        params.put("bonusPercentage",platform.getBonusPercentage());
        headerMap.put("x-auth-token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50IjoiYWRtaW4iLCJwYXNzd29yZCI6ImFkbWluIiwicm9sZSI6MSwiZXhwIjoxNTk5Nzg2OTE0MjYzfQ.0KoVZm5ik4SYhgklo7nW596fupgjkM6P9NKBTt0GE6E");
        String res = null;
        try {
            res = HttpUtil.post(UrlConstans.BASEURL+UrlConstans.PLATFORM, headerMap, JSON.toJSONString(params));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("新增平台返回值：---->>>>"+res);
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

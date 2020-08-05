package com.platform.modules.platform.controller;

import java.util.Arrays;
import java.util.Map;

import ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.modules.platform.entity.PlatformEntity;
import com.platform.modules.platform.service.PlatformService;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;



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
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("platform:platform:save")
    public R save(@RequestBody PlatformEntity platform){
        platformService.save(platform);

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

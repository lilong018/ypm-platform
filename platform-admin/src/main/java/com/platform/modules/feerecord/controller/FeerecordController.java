package com.platform.modules.feerecord.controller;

import java.util.Arrays;
import java.util.Map;

import com.platform.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.modules.feerecord.entity.FeerecordEntity;
import com.platform.modules.feerecord.service.FeerecordService;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;



/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-08-07 14:53:36
 */
@RestController
@RequestMapping("feerecord/feerecord")
public class FeerecordController {
    @Autowired
    private FeerecordService feerecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("feerecord:feerecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feerecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("feerecord:feerecord:info")
    public R info(@PathVariable("id") String id){
        FeerecordEntity feerecord = feerecordService.getById(id);

        return R.ok().put("feerecord", feerecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("feerecord:feerecord:save")
    public R save(@RequestBody FeerecordEntity feerecord){
        feerecordService.save(feerecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("feerecord:feerecord:update")
    public R update(@RequestBody FeerecordEntity feerecord){
        ValidatorUtils.validateEntity(feerecord);
        feerecordService.updateById(feerecord);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("feerecord:feerecord:delete")
    public R delete(@RequestBody String[] ids){
        feerecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

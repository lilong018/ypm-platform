package com.platform.modules.bank.controller;

import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.bank.entity.BankEntity;
import com.platform.modules.bank.service.BankService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-07-12 15:52:25
 */
@RestController
@RequestMapping("bank")
public class BankController {
    @Autowired
    private BankService bankService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bank:bank:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bankService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bank:bank:info")
    public R info(@PathVariable("id") String id){
        BankEntity bank = bankService.getById(id);

        return R.ok().put("bank", bank);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bank:bank:save")
    public R save(@RequestBody BankEntity bank){
        bankService.save(bank);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bank:bank:update")
    public R update(@RequestBody BankEntity bank){
        ValidatorUtils.validateEntity(bank);
        bankService.updateById(bank);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bank:bank:delete")
    public R delete(@RequestBody String[] ids){
        bankService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

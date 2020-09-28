package com.platform.modules.enterprise.controller;

import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.bank.service.BankService;
import com.platform.modules.enterprise.entity.EnteroriseInfo;
import com.platform.modules.enterprise.entity.EnteroriseReviewEntity;
import com.platform.modules.enterprise.entity.EnterpriseEntity;
import com.platform.modules.enterprise.service.EnterpriseService;
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
 * @date 2020-07-08 09:03:00
 */
@RestController
@RequestMapping("enterprise/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private BankService bankService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("enterprise:enterprise:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = enterpriseService.selectPages(params);

        return R.ok().put("page", page);

    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enterprise:enterprise:info")
    public R info(@PathVariable("id") String id){
        EnteroriseInfo enteroriseInfo = enterpriseService.findById(id);
        System.out.println();
        return R.ok().put("enterprise",enteroriseInfo);
    }

    /**
     * 信息
     */
    @RequestMapping("/accept/{id}")
    public R accept(@PathVariable("id") String id){
        System.out.println(id);
        boolean flag = enterpriseService.accept(id);
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("enterprise:enterprise:save")
    public R save(@RequestBody EnterpriseEntity enterprise){
        enterpriseService.save(enterprise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("enterprise:enterprise:update")
    public R update(@RequestBody EnterpriseEntity enterprise){
        ValidatorUtils.validateEntity(enterprise);

        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("enterprise:enterprise:delete")
    public R delete(@RequestBody String[] ids){
        enterpriseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/review")
    public R pass(@RequestBody EnteroriseReviewEntity req){
        enterpriseService.review(req);
        return R.ok();
    }


}

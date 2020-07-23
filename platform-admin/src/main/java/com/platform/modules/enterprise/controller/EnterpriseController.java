package com.platform.modules.enterprise.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.bank.entity.BankEntity;
import com.platform.modules.bank.service.BankService;
import com.platform.modules.enterprise.entity.EnteroriseInfo;
import com.platform.modules.enterprise.entity.EnteroriseRejectEntity;
import com.platform.modules.enterprise.entity.EnterpriseEntity;
import com.platform.modules.enterprise.service.EnterpriseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;

import javax.servlet.http.HttpServletRequest;


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
        PageUtils page = enterpriseService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enterprise:enterprise:info")
    public R info(@PathVariable("id") String id){
        EnterpriseEntity enterprise = enterpriseService.getById(id);
        List<BankEntity> banks = bankService.getByEnterpriseId(id);
        EnteroriseInfo enteroriseInfo = new EnteroriseInfo(enterprise,banks);
        return R.ok().put("enterprise", enteroriseInfo);
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
        enterpriseService.updateById(enterprise);
        
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
    @RequestMapping("/noPass")
    public R noPass(@RequestBody EnteroriseRejectEntity req){
        System.out.println(req);
        return R.ok();
    }

}

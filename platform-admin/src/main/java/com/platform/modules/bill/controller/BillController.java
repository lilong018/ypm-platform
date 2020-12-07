package com.platform.modules.bill.controller;

import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;
import com.platform.common.utils.StringUtil;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.bill.entity.BankListVo;
import com.platform.modules.bill.entity.BillEntity;
import com.platform.modules.bill.entity.BillResults;
import com.platform.modules.bill.service.BillService;
import com.platform.modules.enterprise.entity.EnteroriseReviewEntity;
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
 * @date 2020-07-12 15:51:47
 */
@RestController
@RequestMapping("bill/bill")
public class BillController {
    @Autowired
    private BillService billService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:bill:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = billService.selectPages(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:bill:info")
    public R info(@PathVariable("id") String id){
        System.out.println("id:"+id);
        if (StringUtil.isBlank(id)) {
            return R.error("参数不可为空");
        }
        BankListVo bill = billService.findById(id);

        return R.ok().put("bill", bill);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:bill:save")
    public R save(@RequestBody BillEntity bill){
        billService.save(bill);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:bill:update")
    public R update(@RequestBody BillEntity bill){
        ValidatorUtils.validateEntity(bill);
        billService.updateById(bill);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:bill:delete")
    public R delete(@RequestBody String[] ids){
        billService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/audit")
    public R accept(@RequestBody EnteroriseReviewEntity req){
        boolean flag = billService.audit(req);
        return R.ok();
    }

}

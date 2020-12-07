package com.platform.modules.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.bill.entity.BankListVo;
import com.platform.modules.bill.entity.BillEntity;
import com.platform.modules.bill.entity.BillResults;
import com.platform.modules.enterprise.entity.EnteroriseReviewEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-07-12 15:51:47
 */
public interface BillService extends IService<BillEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils selectPages(Map<String, Object> params);

    BankListVo findById(String id);

    boolean audit(EnteroriseReviewEntity revie);
}


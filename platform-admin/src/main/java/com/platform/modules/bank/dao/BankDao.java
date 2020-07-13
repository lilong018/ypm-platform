package com.platform.modules.bank.dao;

import com.platform.modules.bank.entity.BankEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author ll
 * @email 
 * @date 2020-07-12 15:52:25
 */
@Mapper
public interface BankDao extends BaseMapper<BankEntity> {

     List<BankEntity> getByEnterpriseId(String enterpriseId);
}

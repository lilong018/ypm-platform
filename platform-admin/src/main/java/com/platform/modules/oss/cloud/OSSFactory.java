/**
 * Copyright (c) 2016-2019 有票么 All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.platform.modules.oss.cloud;


import com.platform.modules.sys.service.SysConfigService;
import com.platform.common.utils.ConfigConstant;
import com.platform.common.utils.Constant;
import com.platform.common.utils.SpringContextUtils;

/**
 * 文件上传Factory
 *
 * @author Mark sunlightcs@gmail.com
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}

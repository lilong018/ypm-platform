/**
 * Copyright (c) 2016-2019 有票么 All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.platform.common.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @author Mark sunlightcs@gmail.com
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
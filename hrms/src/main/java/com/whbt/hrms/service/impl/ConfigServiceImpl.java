
package com.whbt.hrms.service.impl;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whbt.hrms.dao.ConfigDao;
import com.whbt.hrms.entity.ConfigEntity;
import com.whbt.hrms.service.ConfigService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.Query;


/**
 * 系统用户
 */
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper) {
		Page<ConfigEntity> page = this.selectPage(
                new Query<ConfigEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
	}
}

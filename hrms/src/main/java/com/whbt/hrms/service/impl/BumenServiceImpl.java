package com.whbt.hrms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.Query;


import com.whbt.hrms.dao.BumenDao;
import com.whbt.hrms.entity.BumenEntity;
import com.whbt.hrms.service.BumenService;
import com.whbt.hrms.entity.vo.BumenVO;
import com.whbt.hrms.entity.view.BumenView;

@Service("bumenService")
public class BumenServiceImpl extends ServiceImpl<BumenDao, BumenEntity> implements BumenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BumenEntity> page = this.selectPage(
                new Query<BumenEntity>(params).getPage(),
                new EntityWrapper<BumenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BumenEntity> wrapper) {
		  Page<BumenView> page =new Query<BumenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BumenVO> selectListVO(Wrapper<BumenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BumenVO selectVO(Wrapper<BumenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BumenView> selectListView(Wrapper<BumenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BumenView selectView(Wrapper<BumenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

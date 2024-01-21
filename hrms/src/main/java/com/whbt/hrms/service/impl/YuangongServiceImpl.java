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


import com.whbt.hrms.dao.YuangongDao;
import com.whbt.hrms.entity.YuangongEntity;
import com.whbt.hrms.service.YuangongService;
import com.whbt.hrms.entity.vo.YuangongVO;
import com.whbt.hrms.entity.view.YuangongView;

@Service("yuangongService")
public class YuangongServiceImpl extends ServiceImpl<YuangongDao, YuangongEntity> implements YuangongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongEntity> page = this.selectPage(
                new Query<YuangongEntity>(params).getPage(),
                new EntityWrapper<YuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongEntity> wrapper) {
		  Page<YuangongView> page =new Query<YuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongVO selectVO(Wrapper<YuangongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongView selectView(Wrapper<YuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

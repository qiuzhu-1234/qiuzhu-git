package com.whbt.hrms.dao;

import com.whbt.hrms.entity.JiabanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.vo.JiabanshenqingVO;
import com.whbt.hrms.entity.view.JiabanshenqingView;


/**
 * 加班申请
 * 
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
public interface JiabanshenqingDao extends BaseMapper<JiabanshenqingEntity> {
	
	List<JiabanshenqingVO> selectListVO(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	
	JiabanshenqingVO selectVO(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	
	List<JiabanshenqingView> selectListView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);

	List<JiabanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	
	JiabanshenqingView selectView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
	

}

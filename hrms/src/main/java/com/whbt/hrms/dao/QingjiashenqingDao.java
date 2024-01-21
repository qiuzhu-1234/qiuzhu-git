package com.whbt.hrms.dao;

import com.whbt.hrms.entity.QingjiashenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.vo.QingjiashenqingVO;
import com.whbt.hrms.entity.view.QingjiashenqingView;


/**
 * 请假申请
 * 
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
public interface QingjiashenqingDao extends BaseMapper<QingjiashenqingEntity> {
	
	List<QingjiashenqingVO> selectListVO(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	
	QingjiashenqingVO selectVO(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	
	List<QingjiashenqingView> selectListView(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);

	List<QingjiashenqingView> selectListView(Pagination page,@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	
	QingjiashenqingView selectView(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	

}

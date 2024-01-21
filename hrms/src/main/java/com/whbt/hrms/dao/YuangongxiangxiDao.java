package com.whbt.hrms.dao;

import com.whbt.hrms.entity.YuangongxiangxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.vo.YuangongxiangxiVO;
import com.whbt.hrms.entity.view.YuangongxiangxiView;


/**
 * 员工详细
 * 
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
public interface YuangongxiangxiDao extends BaseMapper<YuangongxiangxiEntity> {
	
	List<YuangongxiangxiVO> selectListVO(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
	
	YuangongxiangxiVO selectVO(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
	
	List<YuangongxiangxiView> selectListView(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);

	List<YuangongxiangxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
	
	YuangongxiangxiView selectView(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
	

}

package com.whbt.hrms.dao;

import com.whbt.hrms.entity.ZhaopinjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.vo.ZhaopinjihuaVO;
import com.whbt.hrms.entity.view.ZhaopinjihuaView;


/**
 * 招聘计划
 * 
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
public interface ZhaopinjihuaDao extends BaseMapper<ZhaopinjihuaEntity> {
	
	List<ZhaopinjihuaVO> selectListVO(@Param("ew") Wrapper<ZhaopinjihuaEntity> wrapper);
	
	ZhaopinjihuaVO selectVO(@Param("ew") Wrapper<ZhaopinjihuaEntity> wrapper);
	
	List<ZhaopinjihuaView> selectListView(@Param("ew") Wrapper<ZhaopinjihuaEntity> wrapper);

	List<ZhaopinjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopinjihuaEntity> wrapper);
	
	ZhaopinjihuaView selectView(@Param("ew") Wrapper<ZhaopinjihuaEntity> wrapper);
	

}

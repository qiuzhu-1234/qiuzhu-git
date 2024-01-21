package com.whbt.hrms.dao;

import com.whbt.hrms.entity.YuangonggongziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.vo.YuangonggongziVO;
import com.whbt.hrms.entity.view.YuangonggongziView;


/**
 * 员工工资
 * 
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
public interface YuangonggongziDao extends BaseMapper<YuangonggongziEntity> {
	
	List<YuangonggongziVO> selectListVO(@Param("ew") Wrapper<YuangonggongziEntity> wrapper);
	
	YuangonggongziVO selectVO(@Param("ew") Wrapper<YuangonggongziEntity> wrapper);
	
	List<YuangonggongziView> selectListView(@Param("ew") Wrapper<YuangonggongziEntity> wrapper);

	List<YuangonggongziView> selectListView(Pagination page,@Param("ew") Wrapper<YuangonggongziEntity> wrapper);
	
	YuangonggongziView selectView(@Param("ew") Wrapper<YuangonggongziEntity> wrapper);
	

}

package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.YuangongEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.YuangongVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.YuangongView;


/**
 * 员工
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface YuangongService extends IService<YuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper);
   	
   	YuangongVO selectVO(@Param("ew") Wrapper<YuangongEntity> wrapper);
   	
   	List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper);
   	
   	YuangongView selectView(@Param("ew") Wrapper<YuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongEntity> wrapper);
   	

}


package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.JiabanshenqingEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.JiabanshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.JiabanshenqingView;


/**
 * 加班申请
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface JiabanshenqingService extends IService<JiabanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiabanshenqingVO> selectListVO(Wrapper<JiabanshenqingEntity> wrapper);
   	
   	JiabanshenqingVO selectVO(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
   	
   	List<JiabanshenqingView> selectListView(Wrapper<JiabanshenqingEntity> wrapper);
   	
   	JiabanshenqingView selectView(@Param("ew") Wrapper<JiabanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiabanshenqingEntity> wrapper);
   	

}


package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.YuangongpeixunEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.YuangongpeixunVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.YuangongpeixunView;


/**
 * 员工培训
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface YuangongpeixunService extends IService<YuangongpeixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongpeixunVO> selectListVO(Wrapper<YuangongpeixunEntity> wrapper);
   	
   	YuangongpeixunVO selectVO(@Param("ew") Wrapper<YuangongpeixunEntity> wrapper);
   	
   	List<YuangongpeixunView> selectListView(Wrapper<YuangongpeixunEntity> wrapper);
   	
   	YuangongpeixunView selectView(@Param("ew") Wrapper<YuangongpeixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongpeixunEntity> wrapper);
   	

}


package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.BumenpeixunEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.BumenpeixunVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.BumenpeixunView;


/**
 * 部门培训
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface BumenpeixunService extends IService<BumenpeixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BumenpeixunVO> selectListVO(Wrapper<BumenpeixunEntity> wrapper);
   	
   	BumenpeixunVO selectVO(@Param("ew") Wrapper<BumenpeixunEntity> wrapper);
   	
   	List<BumenpeixunView> selectListView(Wrapper<BumenpeixunEntity> wrapper);
   	
   	BumenpeixunView selectView(@Param("ew") Wrapper<BumenpeixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BumenpeixunEntity> wrapper);
   	

}


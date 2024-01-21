package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.YuangongxiangxiEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.YuangongxiangxiVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.YuangongxiangxiView;


/**
 * 员工详细
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface YuangongxiangxiService extends IService<YuangongxiangxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongxiangxiVO> selectListVO(Wrapper<YuangongxiangxiEntity> wrapper);
   	
   	YuangongxiangxiVO selectVO(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
   	
   	List<YuangongxiangxiView> selectListView(Wrapper<YuangongxiangxiEntity> wrapper);
   	
   	YuangongxiangxiView selectView(@Param("ew") Wrapper<YuangongxiangxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongxiangxiEntity> wrapper);
   	

}


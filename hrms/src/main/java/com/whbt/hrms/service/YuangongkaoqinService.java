package com.whbt.hrms.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.entity.YuangongkaoqinEntity;
import java.util.List;
import java.util.Map;
import com.whbt.hrms.entity.vo.YuangongkaoqinVO;
import org.apache.ibatis.annotations.Param;
import com.whbt.hrms.entity.view.YuangongkaoqinView;


/**
 * 员工考勤
 *
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
public interface YuangongkaoqinService extends IService<YuangongkaoqinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongkaoqinVO> selectListVO(Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	YuangongkaoqinVO selectVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	List<YuangongkaoqinView> selectListView(Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	YuangongkaoqinView selectView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongkaoqinEntity> wrapper);
   	

}


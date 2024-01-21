package com.whbt.hrms.entity.view;

import com.whbt.hrms.entity.YuangongpeixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 员工培训
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 */
@TableName("yuangongpeixun")
public class YuangongpeixunView  extends YuangongpeixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuangongpeixunView(){
	}
 
 	public YuangongpeixunView(YuangongpeixunEntity yuangongpeixunEntity){
 	try {
			BeanUtils.copyProperties(this, yuangongpeixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

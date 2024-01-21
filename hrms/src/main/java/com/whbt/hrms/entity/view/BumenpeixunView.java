package com.whbt.hrms.entity.view;

import com.whbt.hrms.entity.BumenpeixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 部门培训
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 */
@TableName("bumenpeixun")
public class BumenpeixunView  extends BumenpeixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BumenpeixunView(){
	}
 
 	public BumenpeixunView(BumenpeixunEntity bumenpeixunEntity){
 	try {
			BeanUtils.copyProperties(this, bumenpeixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

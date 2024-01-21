package com.whbt.hrms.entity.view;

import com.whbt.hrms.entity.YuangongxiangxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 员工详细
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 */
@TableName("yuangongxiangxi")
public class YuangongxiangxiView  extends YuangongxiangxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuangongxiangxiView(){
	}
 
 	public YuangongxiangxiView(YuangongxiangxiEntity yuangongxiangxiEntity){
 	try {
			BeanUtils.copyProperties(this, yuangongxiangxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

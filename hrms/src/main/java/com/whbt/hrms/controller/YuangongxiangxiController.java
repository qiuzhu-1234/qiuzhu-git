package com.whbt.hrms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.whbt.hrms.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.whbt.hrms.annotation.IgnoreAuth;

import com.whbt.hrms.entity.YuangongxiangxiEntity;
import com.whbt.hrms.entity.view.YuangongxiangxiView;

import com.whbt.hrms.service.YuangongxiangxiService;
import com.whbt.hrms.service.TokenService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.R;
import com.whbt.hrms.utils.MD5Util;
import com.whbt.hrms.utils.MPUtil;
import com.whbt.hrms.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工详细
 * 后端接口
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
@RestController
@RequestMapping("/yuangongxiangxi")
public class YuangongxiangxiController {
    @Autowired
    private YuangongxiangxiService yuangongxiangxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongxiangxiEntity yuangongxiangxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongxiangxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongxiangxiEntity> ew = new EntityWrapper<YuangongxiangxiEntity>();
		PageUtils page = yuangongxiangxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongxiangxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongxiangxiEntity yuangongxiangxi, 
		HttpServletRequest request){
        EntityWrapper<YuangongxiangxiEntity> ew = new EntityWrapper<YuangongxiangxiEntity>();
		PageUtils page = yuangongxiangxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongxiangxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongxiangxiEntity yuangongxiangxi){
       	EntityWrapper<YuangongxiangxiEntity> ew = new EntityWrapper<YuangongxiangxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongxiangxi, "yuangongxiangxi")); 
        return R.ok().put("data", yuangongxiangxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongxiangxiEntity yuangongxiangxi){
        EntityWrapper< YuangongxiangxiEntity> ew = new EntityWrapper< YuangongxiangxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongxiangxi, "yuangongxiangxi")); 
		YuangongxiangxiView yuangongxiangxiView =  yuangongxiangxiService.selectView(ew);
		return R.ok("查询员工详细成功").put("data", yuangongxiangxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongxiangxiEntity yuangongxiangxi = yuangongxiangxiService.selectById(id);
        return R.ok().put("data", yuangongxiangxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongxiangxiEntity yuangongxiangxi = yuangongxiangxiService.selectById(id);
        return R.ok().put("data", yuangongxiangxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongxiangxiEntity yuangongxiangxi, HttpServletRequest request){
    	yuangongxiangxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongxiangxi);
        yuangongxiangxiService.insert(yuangongxiangxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongxiangxiEntity yuangongxiangxi, HttpServletRequest request){
    	yuangongxiangxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongxiangxi);
        yuangongxiangxiService.insert(yuangongxiangxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongxiangxiEntity yuangongxiangxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongxiangxi);
        yuangongxiangxiService.updateById(yuangongxiangxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongxiangxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YuangongxiangxiEntity> wrapper = new EntityWrapper<YuangongxiangxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuangongxiangxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
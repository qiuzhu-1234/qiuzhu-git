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

import com.whbt.hrms.entity.BumenpeixunEntity;
import com.whbt.hrms.entity.view.BumenpeixunView;

import com.whbt.hrms.service.BumenpeixunService;
import com.whbt.hrms.service.TokenService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.R;
import com.whbt.hrms.utils.MD5Util;
import com.whbt.hrms.utils.MPUtil;
import com.whbt.hrms.utils.CommonUtil;
import java.io.IOException;

/**
 * 部门培训
 * 后端接口
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
@RestController
@RequestMapping("/bumenpeixun")
public class BumenpeixunController {
    @Autowired
    private BumenpeixunService bumenpeixunService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BumenpeixunEntity bumenpeixun,
		HttpServletRequest request){
        EntityWrapper<BumenpeixunEntity> ew = new EntityWrapper<BumenpeixunEntity>();
		PageUtils page = bumenpeixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bumenpeixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BumenpeixunEntity bumenpeixun, 
		HttpServletRequest request){
        EntityWrapper<BumenpeixunEntity> ew = new EntityWrapper<BumenpeixunEntity>();
		PageUtils page = bumenpeixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bumenpeixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BumenpeixunEntity bumenpeixun){
       	EntityWrapper<BumenpeixunEntity> ew = new EntityWrapper<BumenpeixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bumenpeixun, "bumenpeixun")); 
        return R.ok().put("data", bumenpeixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BumenpeixunEntity bumenpeixun){
        EntityWrapper< BumenpeixunEntity> ew = new EntityWrapper< BumenpeixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bumenpeixun, "bumenpeixun")); 
		BumenpeixunView bumenpeixunView =  bumenpeixunService.selectView(ew);
		return R.ok("查询部门培训成功").put("data", bumenpeixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BumenpeixunEntity bumenpeixun = bumenpeixunService.selectById(id);
        return R.ok().put("data", bumenpeixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BumenpeixunEntity bumenpeixun = bumenpeixunService.selectById(id);
        return R.ok().put("data", bumenpeixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BumenpeixunEntity bumenpeixun, HttpServletRequest request){
    	bumenpeixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bumenpeixun);
        bumenpeixunService.insert(bumenpeixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BumenpeixunEntity bumenpeixun, HttpServletRequest request){
    	bumenpeixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bumenpeixun);
        bumenpeixunService.insert(bumenpeixun);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BumenpeixunEntity bumenpeixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bumenpeixun);
        bumenpeixunService.updateById(bumenpeixun);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bumenpeixunService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BumenpeixunEntity> wrapper = new EntityWrapper<BumenpeixunEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = bumenpeixunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

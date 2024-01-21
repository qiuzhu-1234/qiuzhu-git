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

import com.whbt.hrms.entity.JiabanshenqingEntity;
import com.whbt.hrms.entity.view.JiabanshenqingView;

import com.whbt.hrms.service.JiabanshenqingService;
import com.whbt.hrms.service.TokenService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.R;
import com.whbt.hrms.utils.MD5Util;
import com.whbt.hrms.utils.MPUtil;
import com.whbt.hrms.utils.CommonUtil;
import java.io.IOException;

/**
 * 加班申请
 * 后端接口
 * @author 
 * @email
 * @date 2024-01-15 17:13:54
 */
@RestController
@RequestMapping("/jiabanshenqing")
public class JiabanshenqingController {
    @Autowired
    private JiabanshenqingService jiabanshenqingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiabanshenqingEntity jiabanshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			jiabanshenqing.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiabanshenqingEntity> ew = new EntityWrapper<JiabanshenqingEntity>();
		PageUtils page = jiabanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiabanshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiabanshenqingEntity jiabanshenqing, 
		HttpServletRequest request){
        EntityWrapper<JiabanshenqingEntity> ew = new EntityWrapper<JiabanshenqingEntity>();
		PageUtils page = jiabanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiabanshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiabanshenqingEntity jiabanshenqing){
       	EntityWrapper<JiabanshenqingEntity> ew = new EntityWrapper<JiabanshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiabanshenqing, "jiabanshenqing")); 
        return R.ok().put("data", jiabanshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiabanshenqingEntity jiabanshenqing){
        EntityWrapper< JiabanshenqingEntity> ew = new EntityWrapper< JiabanshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiabanshenqing, "jiabanshenqing")); 
		JiabanshenqingView jiabanshenqingView =  jiabanshenqingService.selectView(ew);
		return R.ok("查询加班申请成功").put("data", jiabanshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiabanshenqingEntity jiabanshenqing = jiabanshenqingService.selectById(id);
        return R.ok().put("data", jiabanshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiabanshenqingEntity jiabanshenqing = jiabanshenqingService.selectById(id);
        return R.ok().put("data", jiabanshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiabanshenqingEntity jiabanshenqing, HttpServletRequest request){
    	jiabanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiabanshenqing);
        jiabanshenqingService.insert(jiabanshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiabanshenqingEntity jiabanshenqing, HttpServletRequest request){
    	jiabanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiabanshenqing);
        jiabanshenqingService.insert(jiabanshenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiabanshenqingEntity jiabanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiabanshenqing);
        jiabanshenqingService.updateById(jiabanshenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiabanshenqingService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JiabanshenqingEntity> wrapper = new EntityWrapper<JiabanshenqingEntity>();
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

		int count = jiabanshenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

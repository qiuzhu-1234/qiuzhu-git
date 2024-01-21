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

import com.whbt.hrms.entity.ZhaopinjihuaEntity;
import com.whbt.hrms.entity.view.ZhaopinjihuaView;

import com.whbt.hrms.service.ZhaopinjihuaService;
import com.whbt.hrms.service.TokenService;
import com.whbt.hrms.utils.PageUtils;
import com.whbt.hrms.utils.R;
import com.whbt.hrms.utils.MD5Util;
import com.whbt.hrms.utils.MPUtil;
import com.whbt.hrms.utils.CommonUtil;
import java.io.IOException;

/**
 * 招聘计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-15 17:13:54
 */
@RestController
@RequestMapping("/zhaopinjihua")
public class ZhaopinjihuaController {
    @Autowired
    private ZhaopinjihuaService zhaopinjihuaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaopinjihuaEntity zhaopinjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			zhaopinjihua.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaopinjihuaEntity> ew = new EntityWrapper<ZhaopinjihuaEntity>();
		PageUtils page = zhaopinjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaopinjihuaEntity zhaopinjihua, 
		HttpServletRequest request){
        EntityWrapper<ZhaopinjihuaEntity> ew = new EntityWrapper<ZhaopinjihuaEntity>();
		PageUtils page = zhaopinjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinjihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaopinjihuaEntity zhaopinjihua){
       	EntityWrapper<ZhaopinjihuaEntity> ew = new EntityWrapper<ZhaopinjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaopinjihua, "zhaopinjihua")); 
        return R.ok().put("data", zhaopinjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaopinjihuaEntity zhaopinjihua){
        EntityWrapper< ZhaopinjihuaEntity> ew = new EntityWrapper< ZhaopinjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaopinjihua, "zhaopinjihua")); 
		ZhaopinjihuaView zhaopinjihuaView =  zhaopinjihuaService.selectView(ew);
		return R.ok("查询招聘计划成功").put("data", zhaopinjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaopinjihuaEntity zhaopinjihua = zhaopinjihuaService.selectById(id);
        return R.ok().put("data", zhaopinjihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaopinjihuaEntity zhaopinjihua = zhaopinjihuaService.selectById(id);
        return R.ok().put("data", zhaopinjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaopinjihuaEntity zhaopinjihua, HttpServletRequest request){
    	zhaopinjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaopinjihua);
        zhaopinjihuaService.insert(zhaopinjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinjihuaEntity zhaopinjihua, HttpServletRequest request){
    	zhaopinjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaopinjihua);
        zhaopinjihuaService.insert(zhaopinjihua);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhaopinjihuaEntity zhaopinjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaopinjihua);
        zhaopinjihuaService.updateById(zhaopinjihua);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaopinjihuaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhaopinjihuaEntity> wrapper = new EntityWrapper<ZhaopinjihuaEntity>();
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

		int count = zhaopinjihuaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
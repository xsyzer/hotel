package com.example.boot.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entity.admin;
import com.example.boot.entity.user;

import net.minidev.json.JSONObject;
@CrossOrigin
@RestController
public class DbController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @RequestMapping("/doUserLogin")
    public String userLogin(
    		@RequestBody user user){
    	String success ="success";
    	String un=user.getUsername();
    	String up=user.getUserpwd();
        String sql = "select userpwd from user where username='"+un+"'";
//       执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        if(up==maps.get(0).toString()) {
        	return success;
        }
        
		return success ;
    }
    
    @ResponseBody
    @RequestMapping("/doAdminLogin")
    public int adminLogin(
    		@RequestBody admin admin){
    	String success ="success";
    	String an=admin.getAdminName();
    	String ap=admin.getAdminPwd();
        String sql = "select admin_pwd from admin where admin_name='"+an+"'";
//       执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        String s = "select id from admin where admin_name='"+an+"'";
        
         int id=jdbcTemplate.queryForObject(s, int.class);
         return id;
    }
    
    
    @ResponseBody
    @RequestMapping("/doUserReg")
    public String userReg(
    		@RequestBody user user){
    	String success ="success";
    	String un=user.getUsername();
    	String up=user.getUserpwd();
    	String nm=user.getName();
    	String pn=user.getPhonenumber();
    	String ad=user.getAddress();
    	System.out.print(un);
        String sql = "insert into user(username,userpwd,name,address,phonenumber) values('"+un+"','"+up+"','"+nm+"','"+ad+"','"+pn+"')";
        
//       执行sql语句
        jdbcTemplate.update(sql);
		return success ;
    }
   }
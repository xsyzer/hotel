package com.example.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entity.admin;
import com.example.boot.entity.dishes;
import com.example.boot.entity.user;
@RestController
@CrossOrigin
@ResponseBody
public class DishesController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	 @RequestMapping(value="/getDishes",method=RequestMethod.GET)
	 public List<Map<String, Object>> getDishes(){
	        String sql = "select name,price from dishes";

		 ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//	       执行sql语句
	        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
	       
			return maps;
	    }
	@RequestMapping(value="/doStarUpdate",method=RequestMethod.POST)
	public String doStarUpdate(
			@RequestBody dishes dishes){
		String success="success";
		String name=dishes.getName();
		int score=dishes.getScore();
		String sql_score = "  select score from dishes where name='"+name+"'";
//	       执行sql语句
		String sql_num = "  select num from dishes where name='"+name+"'";
		int total_score=jdbcTemplate.queryForObject(sql_score, int.class);
		int total_num=jdbcTemplate.queryForObject(sql_num, int.class);
		int update_num=total_num+1;
		int update_score=total_score+score;
		int update_star=update_score/update_num;
		String update="update dishes set num='"+update_num+"',score='"+update_score+"',star='"+update_star+"'  where name='"+name+"'";
		jdbcTemplate.update(update);

		return success;
	}

	@RequestMapping(value="/bestOrder",method=RequestMethod.POST)
	public List<Map<String, Object>> best(@RequestBody admin admin){
		int Price=admin.getId();
		int Num=admin.getNum();
		System.out.println(Price);
		System.out.println(Num);
		String sql = "select price from dishes  order by star desc,price asc";
		String sql1 = "select name,price,star from dishes  order by star desc,price asc";
		List<Map<String, Object>> mapsall = jdbcTemplate.queryForList(sql1);
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
		List<Map<String, Object>> mapss =new ArrayList<Map<String, Object>>();

		int add[]=new int[Num];
		List<Object> list=new ArrayList<>();
		for(Map m:maps ){
			for(Object k:m.keySet()){
				System.out.println(m.get(k));
				list.add(m.get(k)) ;
			}
		}
		int a[]=new int [list.size()];
		int b[]=new int [list.size()];
		int sum=0;
		List<Integer> list1=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			a[i]=Integer.parseInt(String.valueOf(list.get(i)));

		}
		int n=0;
		int line=0;
		for(int c=0;c<=list.size();c++){
			if(n<Num&&c<list.size()){
				if(sum<=Price&&n<=Num){
					sum+=a[c];
					if(sum<=Price&&n<=Num){
						b[c]=1;
						n++;
						line=c;
					}
					else {
						sum-=a[c];
						b[c]=0;

					}
				}
			}
			else if(c==list.size()&&n<Num){
				sum-=a[line];
				b[line]=0;
				c=line;
				n--;
			}
		}
		for(int cc: b){
			System.out.println(cc);
		}
		for(int i=0;i<list.size(); i++){
			if(b[i]==1){
				mapss.add(mapsall.get(i));
			}

		}

		return mapss;
	}
	 
	 @RequestMapping(value="/getAdminDish",method=RequestMethod.POST)
	 public List<Map<String, Object>> getAdminDish(
			 @RequestBody admin admin){
		 int id=admin.getId();
	        String sql = "select id,name,price from dishes where admin_id='"+id+"'";
	        
//	       执行sql语句
	        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
	       
			return maps;
	    }
	 
	 @RequestMapping(value="/doDishDelete",method=RequestMethod.POST)
	 public String doDishDelete(
			 @RequestBody dishes dishes){
		 String success="success";
		 int id=dishes.getId();
		 System.out.print(id);
	        String sql = " delete from dishes where id='"+id+"'";
	        
//	       执行sql语句
	       int rows= jdbcTemplate.update(sql);
	       
			return success;
	    }
	 
	 @RequestMapping(value="/doDishUpdate",method=RequestMethod.POST)
	 public String doDishUpdate(
			 @RequestBody dishes dishes){
		 String success="success";
		 int id=dishes.getId();
		 String nm=dishes.getName();
		 String price=dishes.getPrice();
		 System.out.println(id);
		 System.out.println(nm);
		 System.out.println(price);


	        String sql = " update dishes set name='"+nm+"',price='"+price+"' where id ='"+id+"'";
	        
//	       执行sql语句
	  jdbcTemplate.update(sql);
	       
			return success;
	    }
	 
	 
	 @RequestMapping(value="/doDishAdd",method=RequestMethod.POST)
	 public String doDishAdd(
			 @RequestBody dishes dishes){
		 String success="success";
		 int adminid=dishes.getAdminid();
		 String nm=dishes.getName();
		 String price=dishes.getPrice();
	        String sql = "  insert into dishes(name,price,admin_id) values('"+nm+"','"+price+"','"+adminid+"')";
	        
//	       执行sql语句
	  jdbcTemplate.update(sql);
	       
			return success;
	    }
	 
}

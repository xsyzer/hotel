package com.example.boot.controller;

import com.example.boot.entity.admin;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author xsyz
 * @created 2020-06-28   15:29
 */
@RestController
@CrossOrigin
@ResponseBody
public class test {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/a")
    //public List<Object> bestOrder(){
        public List<Map<String, Object>> bestOrder(){
        int Price=150;
        int Num=50;
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

    @RequestMapping(value="/ab",method=RequestMethod.POST)
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

    public static void main(String[] args) {
        test a=new test();
a.bestOrder();


    }


}

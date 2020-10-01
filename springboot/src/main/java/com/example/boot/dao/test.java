//package com.example.boot.dao;
//
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class test {
//    public static void main(String args[]) {
//
//        int num=5;
//        int price=140;
//        List list=new ArrayList();
//        list.add(30);
//        list.add(40);
//        list.add(40);
//        list.add(30);
//        list.add(30);
//        list.add(60);
//        list.add(20);
//        list.add(20);
//        list.add(25);
//        list.add(50);
//        int a[]=new int [list.size()];
//        int b[]=new int [list.size()];
//        int sum=0;
//        List<Integer> list1=new ArrayList<Integer>();
//        for(int i=0;i<list.size();i++){
//         a[i]=Integer.parseInt(String.valueOf(list.get(i)));
//
//        }
//        int n=0;
//        int line=0;
//for(int c=0;c<=list.size();c++){
//    if(n<num&&c<list.size()){
//    if(sum<=price&&n<=num){
//        sum+=a[c];
//        if(sum<=price&&n<=num){
//          b[c]=1;
//          n++;
//          line=c;
//        }
//        else {
//            sum-=a[c];
//            b[c]=0;
//
//        }
//    }
//    }
//    else if(c==list.size()&&n<num){
//            sum-=a[line];
//            b[line]=0;
//            c=line;
//            n--;
//    }
//}
//for(int cc: b){
//    System.out.println(cc);
//}
//
//        }
//
//    }

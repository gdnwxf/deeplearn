package com.wch.test;

/**
 * Created by qinghao on 2017/7/15.
 */
public class CompileTest {

    public static String name = "compiletest" ;


    static {
        System.out.println("类加载的时候执行");
    }



    public String deCode(String code) {
        String temp = null;
        if ("1".equals(code)) {
            temp  = "one" ;
        }else  if ("2".equals(code)) {
            temp  = "two" ;
        }else  if ("3".equals(code)) {
            temp  = "three" ;
        }else  if ("4".equals(code)) {
            temp  = "four" ;
        }
        return  temp;
    }

    public static void dowork() {
        System.out.println(" 开始工作 ");
    }

}

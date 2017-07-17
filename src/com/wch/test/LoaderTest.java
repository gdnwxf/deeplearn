package com.wch.test;

import com.sun.beans.WeakCache;
import com.sun.nio.zipfs.ZipPath;

/**
 * Created by qinghao on 2017/7/14.
 */
public class LoaderTest {


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Integer.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(int.class.getClassLoader());
        System.out.println("file " +  java.io.File.class.getClassLoader());
        System.out.println("weakcache " +  WeakCache.class.getClassLoader());

        ClassLoader appClassLoader = LoaderTest.class.getClassLoader();

        System.out.println(appClassLoader);
        System.out.println(appClassLoader.getParent());
        System.out.println(appClassLoader.getParent().getParent());
        System.out.println(ZipPath.class.getClassLoader());

        System.out.println(CompileTest.name);

        System.out.println("-------------------");

        Class<?> aClass = Class.forName("com.wch.test.CompileTest");
        System.out.println(aClass);
        System.out.println();


    }
}

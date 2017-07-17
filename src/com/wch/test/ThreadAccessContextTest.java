package com.wch.test;

import java.security.AccessControlContext;
import java.security.AccessController;

/**
 * 父子线程的AccessControlContext 是一样的
 * Created by qinghao on 2017/7/17.
 */
public class ThreadAccessContextTest {

    public static void main(String[] args) {
        AccessControlContext context = AccessController.getContext();


        System.out.println("父线程 acc " + context);



        new Thread( () -> {
            AccessControlContext context2 = AccessController.getContext();
            System.out.println("子线程 acc " + context2);
        }).start();


        /**
         * 可获取线程中的ThreadLocal的信息
         */
        final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

    }

}

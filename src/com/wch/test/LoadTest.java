package com.wch.test;

import sun.reflect.Reflection;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by qinghao on 2017/7/17.
 */
public class LoadTest {
    public static void main(String[] args) throws IOException {

        //必须加上的授权的操作才能校验通过
        /**
         * <pre>
         *       授权的 my.policy 文件
         *       grant codeBase  "file:/home/h/client/*"   {
         *          permission java.io.FilePermission  "/1.txt","read";
         *       };
         * </pre>
         *
         */
       String fileName = "c:1.txt";
       /*  AccessController.doPrivileged((PrivilegedAction<Object>) () -> {

                    FilePermission filePermission = new FilePermission(fileName, "read") ;
                    AccessController.checkPermission(filePermission);
                    return null;
                }
        );*/


        System.out.println(" has permission ");
        BufferedReader reader = AccessController.doPrivileged(
                (PrivilegedAction<BufferedReader>) () -> {
                    try {
                        return new BufferedReader( new FileReader(fileName));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

        ) ;

        for (String  str = reader.readLine() ; str != null; str = reader.readLine()) {
            System.out.println(str);
        }

        System.out.println("-----------------");


        System.out.println(Reflection.getCallerClass());

    }
}

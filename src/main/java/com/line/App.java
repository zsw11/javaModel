package com.line;

import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateReplyMessage_1_0;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.shape.Circle;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        addEffect();
//        long[] arr = new long[]{1,4,3,3};
//        List list = Arrays.asList(arr);//基本类型不支持泛型化，会把整个数组当成一个元素放入新的数组，传入可变参数
//        System.out.println(list.size());//打印1
        System.out.println( "Hello World!" );

        long[] arr = new long[]{1l,4l,3l,3l};
        List list = Arrays.asList(arr);
        System.out.println(list.get(0));
        ArrayList<Circle> longs = new ArrayList<Circle>();
        for (Circle s : longs) {
            System.out.println(s.getCenterX());
        }
    }
    public static void addEffect(){
        //不指定下标插入
        int length = 10000000;
        ArrayList<Integer> al = new ArrayList<>();//指定容量时   效率相当
        LinkedList<Integer> ll = new LinkedList<>();

        for(int i=0;i <length;i++){
            ll.add(i);
        }

        long start6 = System.currentTimeMillis();
        ll.add(8888);
        long end6 = System.currentTimeMillis();
        System.out.println(end6-start6);

        for(int i=0;i <length;i++){
            al.add(i);
        }
        long start5 = System.currentTimeMillis();
        al.add(8888);
        long end5 = System.currentTimeMillis();
        System.out.println(end5-start5);
    }
}

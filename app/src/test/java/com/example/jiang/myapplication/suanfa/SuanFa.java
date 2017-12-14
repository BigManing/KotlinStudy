package com.example.jiang.myapplication.suanfa;

import android.util.Log;
import android.util.StateSet;

import com.example.jiang.myapplication.withJava.JavaInKotlin;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import okhttp3.internal.tls.OkHostnameVerifier;

/**
 * Created by BigManing on 17-12-11.
 * 邮箱：lingshui2008@qq.com
 * 算法
 */

public class SuanFa {
        private static int[] scors = {10, 42, 79, 12, 2, 11, 31, 56, 4, 62};
//    private static int[] scors = {2, 4, 10, 11, 12, 31, 42, 56, 62, 79};
//    private static int[] scors = {74, 11, 93, 1, 2};

    /**
     * 基本思想：（分治）
     * 先从数列中取出一个数作为key值；
     * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 对左右两个小数列重复第二步，直至各区间只有1个数。
     */
    @Test
    public void kuaiSuPaiXu() {
        System.out.println("快速排序：");
        System.out.println("变更前：" + Arrays.toString(scors));
        long start = System.nanoTime();
        quickSort(scors, 0, scors.length - 1);
        long end = System.nanoTime();
        System.out.println("消耗时间：" + (end - start) + "钠秒");
        System.out.println("变更后：" + Arrays.toString(scors));
    }

    private void quickSort3(int[] scors, int low, int high) {
        int  start =low;
        int  end=high;
        int  key ;
        if (start<=end) {
            key=scors[start];
            while (start != end) {
                while (start < end && scors[end] >= key) {
                    end--;
                }
                scors[start]=scors[end];
                while (start < end && scors[start] <= key) {
                    start++;
                }
                scors[end] = scors[start];
            }
            scors[start]=key;
            quickSort3(scors, low, start-1);
            quickSort3(scors, start+1, high);
        }

    }

    private void quickSort2(int[] scors, int low, int high) {
        int start =low;
        int end=high;
        int key ;

        if (start<=end) {
            key=scors[low];
            while (start != end) {
                while (start < end && scors[end] >= key) {
                    end--;
                }
                scors[start] = scors[end];
                while (start < end && scors[start] <= key) {
                    start++;
                }
                scors[end] = scors[start];
            }
            scors[start]=key;
            quickSort2(scors,low,start-1);
            quickSort2(scors,start+1,high);
        }


    }

    private void quickSort(int[] a, int l, int r) {
        if (l>=r) {  // 此时只有一个数值  不用排序
            return;
        }
        int i=l;
        int j=r;
        int key = a[l];
        while (i< j) {
            while (i< j && a[j] >= key) {
                j--;
            }
            if (i< j) {
                a[i] = a[j];
                i++;
            }
            while (i< j && a[i] < key) {
                i++;
            }
            if (l < r) {
                a[j] = a[i];
                j--;
            }
        }
        // i==j
        a[i]=key;
        quickSort(a,l,i-1);
        quickSort(a,i+1,r);
    }

    /**
     * 基本思想：
     * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，
     * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    @Test
    public void chaRuPaiXu() {
        System.out.println("插入排序：");
        System.out.println("变更前：" + Arrays.toString(scors));
        long start = System.nanoTime();
        int tmp;
        for (int i = 0; i < scors.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (scors[j - 1] > scors[j]) {
                    tmp = scors[j - 1];
                    scors[j - 1] = scors[j];   //把最小值 交换到最前面
                    scors[j] = tmp;  //  大值  后移
                } else {
                    // 前面的数组已经排序好了 ， 新加入的数值 比排序好的数组的最大值还要大  所以不用再排序了
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("消耗时间：" + (end - start) + "钠秒");
        System.out.println("变更后：" + Arrays.toString(scors));
    }

    /**
     * 选择排序
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     */
    @Test
    public void xuanZePaiXu() {
        System.out.println("选择排序：");
        System.out.println("变更前：" + Arrays.toString(scors));
        long start = System.nanoTime();
        int tmp;
        boolean haveChange;
//        for (int i = 0; i < scors.length; i++) {
//            haveChange = false;
//            for (int j = i + 1; j < scors.length; j++) {
//                if (scors[i] > scors[j]) {
//                    tmp = scors[i];
//                    scors[i] = scors[j];
//                    scors[j] = tmp;
//                    haveChange = true;
//                }
//
//            }
//            System.out.println("第" +
//                    i+
//                    "轮"+Arrays.toString(scors));
//            // 说明已经都排序ok了
//            if (!haveChange) {
//                break;
//            }
//        }

        for (int i = 0; i < scors.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < scors.length; j++) {
                if (scors[minIndex] > scors[j]) {
                    minIndex = j;  //  j索引的值最小
                }
            }
            if (minIndex != i) {  // 如果不是i  就交换
                int temp = scors[i];
                scors[i] = scors[minIndex];   //把最小值 交换到最前面
                scors[minIndex] = temp;  //  大值  后移
            }
        }
        long end = System.nanoTime();
        System.out.println("消耗时间：" + (end - start) + "钠秒");
        System.out.println("变更后：" + Arrays.toString(scors));
    }

    /**
     * 冒泡排序
     * 相邻的两个元素比较   值大的就交换到后面去
     * 两个数比较大小，较大的数下沉，较小的数冒起来。
     */
    @Test
    public void maoPao() {
        System.out.println("冒泡排序：");
        System.out.println("变更前：" + Arrays.toString(scors));
        long start = System.nanoTime();
        int tmp;
        boolean haveChange;
        for (int i = 0; i < scors.length; i++) {
            haveChange = false;
            for (int j = 0; j < scors.length - i - 1; j++) {
                if (scors[j] > scors[j + 1]) {
                    tmp = scors[j];
                    scors[j] = scors[j + 1]; // 小的靠前
                    scors[j + 1] = tmp;  // 大的后移
                    haveChange = true;
                }
            }
            // 说明后面的都已经排序ok了
            if (!haveChange) {
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("消耗时间：" + (end - start) + "钠秒");
        System.out.println("变更后：" + Arrays.toString(scors));
    }
}

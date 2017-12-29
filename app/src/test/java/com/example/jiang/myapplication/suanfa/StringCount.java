package com.example.jiang.myapplication.suanfa;

import com.example.jiang.myapplication.other.JieGouKt;

import org.junit.Test;

/**
 * Created by BigManing on 17-12-28.
 * 邮箱：lingshui2008@qq.com
 * 重复字符串出现的次数
 */

public class StringCount {
    @Test
    public void count() {
        long start = System.nanoTime();
//        String str = "tttssdfkxbssssdfmffmmvvvccxxxzssdfffggh";
        String str = "aaacbb";
        String result = "";
        StringBuffer buffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int count = 0;
        char tmp = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            if (tmp != charArray[i]) {
                buffer.append(i - count).append(tmp);
                count = i;
                tmp = charArray[i];
            }
        }
        buffer.append(charArray.length - count).append(charArray[charArray.length - 1]);
//        result += (charArray.length - count) +""+ charArray[charArray.length - 1];
        System.out.println(System.nanoTime() - start);
        System.out.println(buffer.toString());
//        System.out.println(result);
        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

    }
}

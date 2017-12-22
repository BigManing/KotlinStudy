package com.example.jiang.myapplication.suanfa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.mock.MockContext;

import org.junit.Test;

import java.util.List;

/**
 * Created by BigManing on 17-12-13.
 * 邮箱：lingshui2008@qq.com
 *  单列表 翻转
 */

public class LinkListNode {
    public Node node;

    class Node {
        public int value;
        public Node next;

        public Node(int i) {
            value = i;
        }
    }

    @Test
    public void AA() {
        if (node == null) {
            node = new Node(0);
            Node current = node;
            for (int i = 1; i < 10; i++) {
                Node tmp = new Node(i);
                current.next = tmp;
                current = tmp;
            }
        }
//         打印这个链表
        printLink(node);

//         翻转链表
//        printLink(reverseLink(node));
        printLink(reverseLink2(node));
    }

    // 翻转 链表   递归方式
    /*

    递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 (代码倒数第二句)。
     在上面的代码中， reverseRest 的值没有改变，为该链表的最后一个node，所以，反转后，我们可以得到新链表的head。
    */
    private Node reverseLink2(Node current) {
        if (current == null || current.next==null) {
            return  current;
        }
        System.out.println("--"+current.value);
        Node nextNode = current.next;
        current.next=null;
        Node reverseRest = reverseLink2(nextNode);
        System.out.println("--"+current.value);
        nextNode.next=current;
        return  reverseRest;

    }
    // 翻转 链表   非递归方式
    private Node reverseLink(Node node) {

        Node current  =node;
        Node newHead  =null;
        while (current != null) {
            Node tmp = current.next;  // 获取 后面的链表  这个在后续的判断中有用

            current.next=newHead;   //   吧第一个节点和后续节点断开，它的next值为先前保存的链表
            newHead=current;   //  以备后续使用

            current=tmp;  //  继续遍历下面的链表
        }
        return newHead;
    }

    private void printLink(Node node) {
        while (node != null) {
            System.out.println("node.value:" +
                    node.value);
            node = node.next;
        }
    }
}

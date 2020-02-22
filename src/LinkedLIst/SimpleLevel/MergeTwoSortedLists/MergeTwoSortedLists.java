package LinkedLIst.SimpleLevel.MergeTwoSortedLists;

import java.util.List;

/**
 21. 合并两个有序链表

 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4


 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class MergeTwoSortedLists {

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newHead.next;
    }


    public static void main(String[] args) {
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoSortedLists(l1, l2);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
        System.out.println(res.next.next.next.next.val);
    }

}

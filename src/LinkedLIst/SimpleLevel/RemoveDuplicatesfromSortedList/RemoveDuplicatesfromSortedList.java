package LinkedLIst.SimpleLevel.RemoveDuplicatesfromSortedList;

import java.util.List;

/**
 83. 删除排序链表中的重复元素

 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveDuplicatesfromSortedList{
    public static ListNode removeDuplicatesfromSortedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode res = head;
        while (head != null && head.next != null){
            if (head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        输入: 1->1->2->3->3
//        输出: 1->2->3
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);

        ListNode res = removeDuplicatesfromSortedList(l);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);

    }

}

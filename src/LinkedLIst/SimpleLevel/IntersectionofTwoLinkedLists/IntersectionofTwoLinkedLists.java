package LinkedLIst.SimpleLevel.IntersectionofTwoLinkedLists;

/**
 160. 相交链表

 编写一个程序，找到两个单链表相交的起始节点。

 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Reference of the node with value = 8
 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
            在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


 思路：

     创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
     如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。



 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class IntersectionofTwoLinkedLists {

    public static ListNode intersectionofTwoLinkedLists(ListNode head1, ListNode head2){

        if (head1 == null || head2 == null){
            return null;
        }
        
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != p2){
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }


    public static void main(String[] args) {

    }

}

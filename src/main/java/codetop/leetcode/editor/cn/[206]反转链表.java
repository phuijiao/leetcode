
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1885 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-07 15:40:00
  */

class ReverseLinkedList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode n5 = new ListNode(5);
    ListNode n4 = new ListNode(4, n5);
    ListNode n3 = new ListNode(3, n4);
    ListNode n2 = new ListNode(2, n3);
    ListNode n1 = new ListNode(1, n2);

    solution.reverseList(n1);

  }

  private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //迭代法
    public ListNode reverseList1(ListNode head) {
      ListNode pre = null, cur;
      while (head != null) {
        cur = head;
        head = head.next;
        cur.next = pre;
        pre = cur;
      }
      return pre;
    }

    //递归法
    ListNode pre = null;
    public ListNode reverseList(ListNode head) {
      if (head == null) {
        return null;
      }
      ListNode cur = head;
      head = head.next;
      cur.next = pre;
      pre = cur;
      reverseList(head);
      return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
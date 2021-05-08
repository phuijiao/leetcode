//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 574 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-05-03 15:13:27
 */

class ReorderList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    solution.reorderList(head);
  }


//  Definition for singly-linked list.
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
    public void reorderList(ListNode head) {
      if (head == null || head.next == null) {
        return;
      }
      ListNode fast = head;
      ListNode virtual = new ListNode(0, head);
      ListNode low = virtual;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        low = low.next;
      }

      ListNode pre = null;
      ListNode root = low.next;
      low.next = null;
      ListNode cur;
      while (root != null) {
        cur = root;
        root = root.next;
        cur.next = pre;
        pre = cur;
      }

      ListNode positive = head;
      ListNode reverse = pre;
      ListNode tmp = virtual;
      while (positive != null) {
        tmp.next = positive;
        positive = positive.next;
        tmp = tmp.next;
        tmp.next = reverse;
        reverse = reverse.next;
        tmp = tmp.next;
      }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

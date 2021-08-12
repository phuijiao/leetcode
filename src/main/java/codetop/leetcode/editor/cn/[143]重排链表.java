
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 640 👎 0

package codetop.leetcode.editor.cn;
/**
 * @Author phuijiao
 * @date 2021-08-12 14:08:44
 */
 
class ReorderList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
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
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next, pre = null, cur;
        slow.next = null;
        while (tmp != null) {
            cur = tmp;
            tmp = tmp.next;
            cur.next = pre;
            pre = cur;
        }
        ListNode root = new ListNode();
        tmp = root;
        while (pre != null) {
            tmp.next = head;
            head = head.next;
            tmp = tmp.next;
            tmp.next = pre;
            pre = pre.next;
            tmp = tmp.next;
        }
        if (head != null) {
            tmp.next = head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

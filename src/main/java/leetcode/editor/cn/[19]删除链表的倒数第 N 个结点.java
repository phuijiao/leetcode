//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1342 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-04-29 09:54:12
 */

class RemoveNthNodeFromEndOfList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode root = new ListNode();
      root.next = head;
      ListNode fast = head;
      ListNode low = root;
      while (fast != null) {
        fast = fast.next;
        if (--n < 0) {
          low = low.next;
        }
      }
      low.next = low.next.next;
      return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

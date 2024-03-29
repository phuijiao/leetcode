
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 1013 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-21 15:28:51
  */

class SwapNodesInPairs {
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
    public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode root = new ListNode(0, head);
      ListNode tmp = root;
      while (head != null && head.next != null) {
        tmp.next = head.next;
        head.next = tmp.next.next;
        tmp.next.next = head;
        tmp = head;
        head = head.next;
      }
      return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
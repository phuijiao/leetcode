//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 970 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-15 09:27:52
 */

class ReverseNodesInKGroup{
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode node5 = new ListNode(5);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode node = solution.reverseKGroup(node1, 2);
    System.out.println(node);
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
    public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || k <= 1) {
        return head;
      }

      ListNode node = new ListNode(0, head);
      ListNode left = node, right = null, tleft = null;
      int i = 0;

      while (head != null) {
        if (++i == k) {
          right = head.next;
          tleft = left.next;
          reverse(left, k, right);
          i = 0;
          left = tleft;
          head = right;
          continue;
        }
        head = head.next;
      }
      return node.next;
    }

    private void reverse(ListNode left, int k, ListNode right) {
      ListNode pre = right, tmp = left.next, cur = null;
      for (int i = 0; i < k; i++) {
        cur = tmp;
        tmp = tmp.next;
        cur.next = pre;
        pre = cur;
      }
      left.next = pre;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


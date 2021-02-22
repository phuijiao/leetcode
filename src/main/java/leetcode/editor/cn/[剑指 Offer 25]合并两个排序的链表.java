// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 分治算法
// 👍 74 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 17:43:39
 */
class HeBingLiangGePaiXuDeLianBiaoLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      ListNode res = new ListNode(0);
      ListNode cur = res;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          cur.next = l1;
          cur = cur.next;
          l1 = l1.next;
        } else {
          cur.next = l2;
          cur = cur.next;
          l2 = l2.next;
        }
      }
      if (l1 == null) {
        cur.next = l2;
      } else if (l2 == null) {
        cur.next = l1;
      }
      return res.next;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

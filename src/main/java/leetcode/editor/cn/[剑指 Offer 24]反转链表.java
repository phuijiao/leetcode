// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 155 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 17:24:58
 */
class FanZhuanLianBiaoLcof {
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
    public ListNode reverseList(ListNode head) {
      ListNode pre = null;
      ListNode res = null;
      while (head != null) {
        res = head;
        head = head.next;
        res.next = pre;
        pre = res;
      }
      return pre;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

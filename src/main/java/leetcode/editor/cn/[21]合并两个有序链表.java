//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1606 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-19 16:46:11
 */

class MergeTwoSortedLists{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head = new ListNode();
      ListNode tmp = head;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          tmp.next = l1;
          l1 = l1.next;
        } else {
          tmp.next = l2;
          l2 = l2.next;
        }
        tmp = tmp.next;
      }
      if (l1 != null) {
        tmp.next = l1;
      }
      if (l2 != null) {
        tmp.next = l2;
      }
      return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


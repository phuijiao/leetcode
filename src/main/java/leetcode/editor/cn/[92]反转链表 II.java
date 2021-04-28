//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 833 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-24 11:12:51
 */

class ReverseLinkedListIi{
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      int i = 1;
      ListNode thead = head;
      ListNode preEnd = null, midEnd = null, postStart = null;
      ListNode pre = null,cur;
      while (thead != null) {
        if (i < left) {
          preEnd = thead;
          thead = thead.next;
        } else if (i <= right) {
          if (i == left) {
            midEnd = thead;
          }
          cur = thead;
          thead = thead.next;
          cur.next = pre;
          pre = cur;
        } else {
          postStart = thead;
          break;
        }
        i++;
      }
      if (preEnd == null) {
        head = pre;
      } else {
        preEnd.next = pre;
      }
      if (postStart != null) {
        midEnd.next = postStart;
      }
      return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


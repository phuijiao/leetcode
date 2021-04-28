//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 924 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-04-04 16:13:13
 */

class PalindromeLinkedList{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }


//   Definition for singly-linked list.
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
    public boolean isPalindrome(ListNode head) {
      if (head == null) {
        return true;
      }
      ListNode fast = head;
      ListNode pre = null, cur;
      while (fast != null) {
        if (fast.next != null) {
          fast = fast.next.next;
        } else {
          head = head.next;
          break;
        }
        cur = head;
        head = head.next;
        cur.next = pre;
        pre = cur;
      }
      while (pre != null) {
        if (pre.val != head.val) {
          return false;
        }
        pre = pre.next;
        head = head.next;
      }
      return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


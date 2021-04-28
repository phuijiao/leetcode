//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1576 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-14 15:21:58
 */

class ReverseLinkedList{
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
    ListNode pre = null, cur = null;
    public ListNode reverseList(ListNode head) {
      while (head != null) {
        cur = head;
        head = head.next;
        cur.next = pre;
        pre = cur;
      }
      return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


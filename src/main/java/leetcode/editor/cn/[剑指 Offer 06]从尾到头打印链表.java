// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
// 输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 79 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author phuijiao
 * @date 2020-12-26 13:18:44
 */
class CongWeiDaoTouDaYinLianBiaoLcof {
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
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {
    // 使用栈存储
    public int[] reversePrint(ListNode head) {
      if (head == null) {
        return new int[0];
      }
      LinkedList<Integer> stack = new LinkedList<>();
      ListNode tmp = head;
      while (tmp != null) {
        stack.push(tmp.val);
        tmp = tmp.next;
      }

      int size = stack.size();
      int[] res = new int[size];
      for (int i = 0; i < size; i++) {
        res[i] = stack.pop();
      }
      return res;
    }

    // 遍历两边链表，一遍取链表长度，一遍反向填充数组
    public int[] reversePrint2(ListNode head) {
      int len = 0;
      ListNode tmp = head;
      while (tmp != null) {
        len++;
        tmp = tmp.next;
      }
      int[] res = new int[len];
      tmp = head;
      while (tmp != null) {
        res[--len] = tmp.val;
        tmp = tmp.next;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

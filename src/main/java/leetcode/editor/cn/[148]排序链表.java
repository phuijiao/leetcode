//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1117 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author phuijiao
 * @date 2021-05-04 13:01:31
 */

class SortList {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }


  //  Definition for singly-linked list.
  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    //优先队列法
    public ListNode sortList1(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
      while (head != null) {
        queue.add(head);
        head = head.next;
      }
      head = queue.poll();
      ListNode tmp = head;
      while (!queue.isEmpty()) {
        tmp.next = queue.poll();
        tmp = tmp.next;
      }
      tmp.next = null;
      return head;
    }


    public ListNode sortList(ListNode head) {
      return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
      if (head == end || head.next == end) {
        return head;
      }
      ListNode lhead = head, rtail = head, p = head.next;
      while (p != end) {
        ListNode next = p.next;
        if (p.val < head.val) {
          p.next = lhead;
          lhead = p;
        } else {
          rtail.next = p;
          rtail = p;
        }
        p = next;
      }
      rtail.next = end;
      ListNode node = quickSort(lhead, head);
      head.next = quickSort(head.next, end);
      return node;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1231 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author  phuijiao
 * @date 2021-03-28 10:18:26
 */

class MergeKSortedLists{
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode[] listNodes = new ListNode[3];
    listNodes[0] = new ListNode(1);
    listNodes[1] = new ListNode(1);
    listNodes[2] = new ListNode(1);
    solution.mergeKLists(listNodes);
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
    public ListNode mergeKLists1(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      int len = lists.length;
      for (int i = 1; i < len; i++) {
        lists[0] = mergeList(lists[0], lists[i]);
      }
      return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
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

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      int len = lists.length;
      if (len == 1) {
        return lists[0];
      }
      PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
      for (int i = 0; i < len; i++) {
        if (lists[i] != null) {
          queue.add(lists[i]);
        }
      }
      ListNode head = new ListNode();
      ListNode tmp = head;
      while (!queue.isEmpty()) {
        ListNode node = queue.poll();
        tmp.next = node;
        tmp = tmp.next;
        if (node.next != null) {
          queue.add(node.next);
        }
      }
      return head.next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


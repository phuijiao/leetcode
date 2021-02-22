package Demo;

/**
 * @Author jiaopenghui
 * @Date 2021/1/22 8:14 下午
 */
public class 回文链表 {
  private static class ListNode{
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode t1 = head;
    ListNode t2 = head;
    ListNode pre = null;
    ListNode tmp;

    while (t2 != null) {
      if (t2.next != null) {
        t2 = t2.next;
        tmp = t1;
        t1 = t1.next;
        tmp.next = pre;
        pre = tmp;
      } else {
        t1 = t1.next;
      }
      t2 = t2.next;
    }
    while (t1 != null) {
      if (t1.val != pre.val) {
        return false;
      }
      t1 = t1.next;
      pre = pre.next;
    }
    return true;
  }





}

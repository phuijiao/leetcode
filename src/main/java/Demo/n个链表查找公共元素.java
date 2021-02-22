package Demo;

/**
 * N个列表，每个链表都是单调递增。都是正整数。 找出N个链表都存在的一个数。没有返回-1
 *
 * 1 2 3 4 5 7
 * 1 3 5 7 9
 * 2 4 6 6 7
 */

import java.util.ArrayList;
import java.util.List;

/** @Author jiaopenghui @Date 2021/1/20 2:07 下午 */
class NListFindComm {
  private static class Node{
    int val;
    Node next;

    public Node(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    List<Node> list = new ArrayList<>();
    list.add(createList(new int[]{1,2,3,4,5,9}));
    list.add(createList(new int[]{1,3,5,7,9}));
    list.add(createList(new int[]{2,4,6,6,7}));

    NListFindComm comm = new NListFindComm();
    int res = comm.allOne(list);
    System.out.println(res);
  }

  private static Node createList(int[] arr) {
    if (arr == null || arr.length == 0){
      return null;
    }
    Node head = new Node(arr[0]);
    Node tmp = head;
    for (int i = 1; i < arr.length; i++) {
      tmp.next = new Node(arr[i]);
      tmp = tmp.next;
    }
    return head;
  }


  public int allOne(List<Node> list) {
    if (list == null || list.size() <= 1) {
      return -1;
    }

    Node node = findOne(list);
    if (node == null) {
      return -1;
    } else {
      return node.val;
    }
  }

  private Node findOne(List<Node> list) {
    int size = list.size();
    Node a = list.get(0);
    for (int i = 1; i < size; i++) {
      a = merge(a,list.get(i));
      if (a == null) {
        return null;
      }
    }
    return a;
  }

  Node res = new Node(0);
  private Node merge(Node a, Node b ) {
    Node tmp = res;
    res.next = null;
    while (a != null && b != null) {
      if (a.val == b.val) {
        tmp.next = a;
        a = a.next;
        tmp.next.next = null;
        tmp = tmp.next;
        b = b.next;
      } else if (a.val < b.val) {
        a = a.next;
      } else {
        b = b.next;
      }
    }

    return res.next;
  }


}

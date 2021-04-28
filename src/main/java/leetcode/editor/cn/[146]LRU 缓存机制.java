//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1240 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author  phuijiao
 * @date 2021-03-15 13:06:54
 */

class Lru{
  public static void main(String[] args) {
//    LRUCache solution = new LRUCache(1);
//    solution.put(1, 1);
//    solution.put(2, 1);
//    solution.get(2);
//    solution.put(3, 3);
//    solution.get(2);
//    solution.put(4,4);
//    solution.get(1);
//    solution.get(3);
//    solution.get(4);
  }




  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache1 {

    //双向链表
    private static int empty = 0;
    private static ListNode head;
    private static ListNode tail;

    public LRUCache1(int capacity) {
      empty = capacity;
      head = new ListNode(0, 0);
      tail = head;
    }
    
    public int get(int key) {
      ListNode tmp = head.next;
      while (tmp != null) {
        if (tmp.key == key) {
          if (tmp != tail) {
            ListNode tNode = tmp;
            tNode.pre.next = tNode.next;
            tNode.next.pre = tNode.pre;
            tNode.pre = tail;
            tNode.next = null;
            tail.next = tNode;
            tail = tail.next;
          }
          return tmp.value;
        }
        tmp = tmp.next;
      }
      return -1;
    }
    
    public void put(int key, int value) {
      int val = get(key);
      if (val != -1) {
        tail.value = value;
      } else if (empty == 0) {
        ListNode tNode = head.next;
        if (tNode.next == null) {
          tNode.key = key;
          tNode.value = value;
        } else {
          head.next = tNode.next;
          tNode.next.pre = head;
          tNode.key = key;
          tNode.value = value;
          tail.next = tNode;
          tNode.pre = tail;
          tNode.next = null;
          tail = tail.next;
        }
      } else {
        ListNode tNode = new ListNode(key, value);
        tail.next = tNode;
        tNode.pre = tail;
        tNode.next = null;
        tail = tail.next;
        empty--;
      }
    }

    static class ListNode{
      int key;
      int value;
      ListNode pre;
      ListNode next;

      ListNode(int k, int v){
        key = k;
        value = v;
      }
    }
}
/************************************************************/

   //LinkedHashMap
class LRUCache2 extends LinkedHashMap<Integer, Integer>{
  private int capacity;

  public LRUCache2(int capacity) {
      super(capacity, 0.75F, true);
      this.capacity = capacity;
  }

  public int get(int key) {
      return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
      super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return super.size() > capacity;
  }
}

//双向链表 + HashMap
class LRUCache {

    private class DLinkedNode {
      private int key;
      private int value;
      DLinkedNode prev;
      DLinkedNode next;

      public DLinkedNode() {}

      public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
      size = 0;
      this.capacity = capacity;
      head = new DLinkedNode();
      tail = new DLinkedNode();
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        return -1;
      }
      moveToHead(node);
      return node.value;
    }

    private void moveToHead(DLinkedNode node) {
      removeNode(node);
      addToHead(node);
    }

    private DLinkedNode removeNode(DLinkedNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
      return node;
    }

    private void addToHead(DLinkedNode node) {
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
      node.prev = head;
      size++;
    }

    public void put(int key, int value) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        DLinkedNode newNode = new DLinkedNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);

        if (size > capacity) {
          DLinkedNode t = removeTail();
          cache.remove(t.key);
        }
      } else {
        node.value = value;
        moveToHead(node);
      }
    }

    private DLinkedNode removeTail() {
      DLinkedNode node = tail.prev;
      return removeNode(node);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//
//
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例：
//
//
//
//
//
//
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
// 第一个节点。
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
//
//
//
//
//
//
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
//
//
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
// to-sorted-doubly-linked-list/
//
// 注意：此题对比原题有改动。
// Related Topics 分治算法
// 👍 143 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.tools.hat.internal.model.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author phuijiao
 * @date 2020-12-14 16:45:10
 */
class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    solution.treeToDoublyList(root);
  }

  private static
  // Definition for a Node.
  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }
  ;

  private static
  // leetcode submit region begin(Prohibit modification and deletion)

  class Solution {

    List<Node> list = new ArrayList<Node>();
    Stack<Node> stack = new Stack<Node>();

    public Node treeToDoublyList2(Node root) {

      if (root == null) {
        return null;
      }
      stack.push(root);
      recur(root);
      Node ret = list.get(0);
      Node tmp = ret;
      for (int i = 1; i < list.size(); i++) {
        Node node = list.get(i);
        tmp.right = node;
        node.left = tmp;
        tmp = tmp.right;
      }
      tmp.right = ret;
      ret.left = tmp;
      return ret;
    }

    private void recur(Node root) {
      while (!stack.isEmpty()) {
        if (root == null) {
          return;
        }
        if (root.left != null) {
          stack.push(root.left);
          recur(root.left);
        }
        list.add(root);
        if (root.right != null) {
          stack.push(root.right);
          recur(root.right);
        }
        stack.pop();
        return;
      }
    }

    /**********************************/
    Node pre, head;

    private void dfs(Node root) {
      if (root == null) {
        return;
      }
      dfs(root.left);
      if (pre != null) {
        pre.right = root;
      } else {
        head = root;
      }
      root.left = pre;
      pre = root;

      dfs(root.right);
    }

    public Node treeToDoublyList(Node root) {
      if (root == null) {
        return null;
      }
      dfs(root);
      pre.right = head;
      head.left = pre;
      return head;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

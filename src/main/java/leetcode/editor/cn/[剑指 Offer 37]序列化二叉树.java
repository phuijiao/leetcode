// 请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
// 序列化为 "[1,2,3,null,null,4,5]"
//
//    1
//   / \
//  2   3
//     /
//    4
//     \
//      5
//     /
//    6
//
// [1, 2, 3, null, null, 4, null, null, null, null, null, null, 5, null, null, null, null, null,
// null, null, null, null, null, null, null, 6, null, null, null, null, null]
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
// inary-tree/
// Related Topics 树 设计
// 👍 94 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author phuijiao
 * @date 2020-12-23 22:45:21
 */
class XuLieHuaErChaShuLcof {
  //  public static void main(String[] args) {
  //    Codec solution = new Codec();
  ////    TreeNode root = new TreeNode(1);
  ////    root.left = new TreeNode(2);
  ////    root.right = new TreeNode(3);
  ////    root.right.left = new TreeNode(4);
  ////    root.right.left.right = new TreeNode(5);
  ////    root.right.left.right.left = new TreeNode(6);
  //    TreeNode root = solution.deserialize("[5,2,3,null,null,2,4,3,1]");
  //    String serialize = solution.serialize(root);
  //    System.out.println(serialize);
  //  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  public class Codec {

    // Encodes a tree to a single string.zhe
    public String serialize1(TreeNode root) {
      if (root == null) {
        return "[]";
      }
      Queue<TreeNode> oddQueue = new LinkedList<>();
      Queue<TreeNode> evenQueue = new LinkedList<>();
      ArrayList<Integer> list = new ArrayList<>();
      oddQueue.add(root);
      while (true) {
        if (!allNull(oddQueue)) {
          boolean flag = false; // 已加入非null元素
          while (!oddQueue.isEmpty()) {
            TreeNode node = oddQueue.remove();
            if (node == null) {
              //              if (flag) {
              list.add(null);
              //              }
              //              evenQueue.add(null);
              //              evenQueue.add(null);
            } else {
              flag = true;
              list.add(node.val);
              evenQueue.add(node.left);
              evenQueue.add(node.right);
            }
          }
        } else {
          break;
        }

        if (!allNull(evenQueue)) {
          boolean flag = false;
          while (!evenQueue.isEmpty()) {
            TreeNode node = evenQueue.remove();
            if (node == null) {
              //              if (flag) {
              list.add(null);
              //              }
              //              oddQueue.add(null);
              //              oddQueue.add(null);
            } else {
              flag = true;
              list.add(node.val);
              oddQueue.add(node.left);
              oddQueue.add(node.right);
            }
          }
        } else {
          break;
        }
      }
      for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i) == null) {
          list.remove(i);
        } else {
          break;
        }
      }

      String s = list.toString();
      return s;
    }

    private boolean allNull(Queue<TreeNode> queue) {
      LinkedList<TreeNode> list = (LinkedList<TreeNode>) queue;
      for (TreeNode node : list) {
        if (node != null) {
          return false;
        }
      }
      return true;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
      if (data == null || data.length() < 3) {
        return null;
      }
      String[] val = data.substring(1, data.length() - 1).split(",");
      int length = val.length;
      TreeNode root = new TreeNode(Integer.parseInt(val[0].trim()));
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int index = 1;
      while (!queue.isEmpty()) {
        TreeNode fa = queue.remove();
        if (index >= length) {
          return root;
        }
        if (!"null".equals(val[index].trim())) {
          TreeNode node = new TreeNode(Integer.parseInt(val[index].trim()));
          fa.left = node;
          queue.add(node);
        }
        index++;
        if (index >= length) {
          return root;
        }
        if (!"null".equals(val[index].trim())) {
          TreeNode node = new TreeNode(Integer.parseInt(val[index].trim()));
          fa.right = node;
          queue.add(node);
        }
        index++;
      }
      return root;
    }

    public String serialize(TreeNode root) {
      if (root == null) {
        return "[]";
      }
      StringBuilder res = new StringBuilder("[");
      Queue<TreeNode> queue =
          new LinkedList<TreeNode>() {
            {
              add(root);
            }
          };
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node != null) {
          res.append(node.val + ",");
          queue.add(node.left);
          queue.add(node.right);
        } else {
          res.append("null,");
        }
      }
      res.deleteCharAt(res.length() - 1);
      res.append("]");
      return res.toString();
    }

    public TreeNode deserialize(String data) {
      if (data.equals("[]")) {
        return null;
      }
      String[] vals = data.substring(1, data.length() - 1).split(",");
      TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
      Queue<TreeNode> queue =
          new LinkedList<TreeNode>() {
            {
              add(root);
            }
          };
      int i = 1;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (!vals[i].equals("null")) {
          node.left = new TreeNode(Integer.parseInt(vals[i]));
          queue.add(node.left);
        }
        i++;
        if (!vals[i].equals("null")) {
          node.right = new TreeNode(Integer.parseInt(vals[i]));
          queue.add(node.right);
        }
        i++;
      }
      return root;
    }
  }

  // Your Codec object will be instantiated and called as such:
  // Codec codec = new Codec();
  // codec.deserialize(codec.serialize(root));
  // leetcode submit region end(Prohibit modification and deletion)

}

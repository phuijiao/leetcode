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

    public String serialize(TreeNode root) {
      if (root == null) {
        return "[]";
      }
      StringBuilder res = new StringBuilder("[");
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node != null) {
          res.append(node.val).append(",");
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
      if (data == null || !data.startsWith("[") || !data.endsWith("]") || data.length() == 2) {
        return null;
      }
      String[] vals = data.substring(1, data.length() - 1).split(",");
      TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
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

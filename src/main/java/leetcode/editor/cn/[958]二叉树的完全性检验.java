//给定一个二叉树，确定它是否是一个完全二叉树。 
//
// 百度百科中对完全二叉树的定义如下： 
//
// 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：
//第 h 层可能包含 1~ 2h 个节点。） 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树中将会有 1 到 100 个结点。 
// 
// Related Topics 树 
// 👍 123 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

/**
* @author phuijiao
* @date 2021-05-13 10:14:46
*/

class CheckCompletenessOfABinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }


//  Definition for a binary tree node.
  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isCompleteTree1(TreeNode root) {
      boolean flag = false;
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.addLast(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.pollFirst();
        if (flag) {
          if (node.left != null || node.right != null) {
            return false;
          }
        } else {
          if (node.left == null) {
            flag = true;
            if (node.right != null) {
              return false;
            }
          } else {
            queue.addLast(node.left);
          }
          if (node.right == null) {
            flag = true;
          } else {
            queue.addLast(node.right);
          }
        }
      }
      return true;
    }

    public boolean isCompleteTree(TreeNode root) {
      boolean flag = false;
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.addLast(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.pollFirst();
        if (node == null) {
          flag = true;
        } else {
          if (flag) {
            return false;
          } else {
            queue.addLast(node.left);
            queue.addLast(node.right);
          }
        }
      }
      return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
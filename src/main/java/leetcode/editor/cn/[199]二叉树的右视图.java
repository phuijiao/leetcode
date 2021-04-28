//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 428 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-03-21 14:43:40
 */

class BinaryTreeRightSideView{
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
    public List<Integer> rightSideView(TreeNode root) {
      ArrayList<Integer> res = new ArrayList<>();
      if (root == null) {
        return res;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          if (node.right != null) {
            queue.add(node.right);
          }
          if (node.left != null) {
            queue.add(node.left);
          }
          if (i == 0) {
            res.add(node.val);
          }
        }
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


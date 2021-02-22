//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 85 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author  phuijiao
 * @date 2021-01-21 16:05:38
 */

class ErChaShuDeShenDuLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }


  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  private static
  //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //层次遍历
    public int maxDepth1(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int deep = 0;
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        deep++;
        for (int size = queue.size(); size > 0; size--) {
          TreeNode node = queue.remove();
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
      }
      return deep;
    }


    //深度优先遍历
    int cur, max;
    public int maxDepth2(TreeNode root) {
      if (root == null) {
        return 0;
      }
      cur = 0;
      max = 0;
      dfs(root);
      return max;
    }

    private void dfs(TreeNode root) {
      if (root == null) {
        return;
      }
      cur++;
      max = Math.max(max, cur);
      dfs(root.left);
      dfs(root.right);
      cur--;
    }

    //递归
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


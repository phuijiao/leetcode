//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 450 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-03-27 15:20:01
 */

class PathSumIi{
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
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      res = new ArrayList<>();
      if (root == null) {
        return res;
      }
      LinkedList<Integer> list = new LinkedList<>();
      recur(root, targetSum, list);
      return res;
    }

    private void recur(TreeNode root, int targetSum, LinkedList<Integer> list) {
      list.add(root.val);
      targetSum -= root.val;
      if (root.left == null && root.right == null && targetSum == 0) {
        res.add(new ArrayList<>(list));
      }
      if (root.left != null) {
        recur(root.left,targetSum,list);
      }
      if (root.right != null) {
        recur(root.right,targetSum,list);
      }
      list.removeLast();
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


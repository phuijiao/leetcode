
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1153 👎 0

package codetop.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author phuijiao
 * @date 2021-08-12 20:52:34
 */
 
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
    Map<Integer, Integer> map;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        map = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, len - 1, 0, len - 1);
    }

    private TreeNode buildTree(int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        Integer ind = map.get(preorder[ps]);

        root.left = buildTree(ps + 1, ps + ind - is, is, ind - 1);
        root.right = buildTree(ps + ind - is + 1, pe, ind + 1, ie);

        return root;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}

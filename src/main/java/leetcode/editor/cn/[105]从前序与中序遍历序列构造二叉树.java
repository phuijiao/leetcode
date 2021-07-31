//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 972 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author  phuijiao
 * @date 2021-04-04 16:36:04
 */

class ConstructBinaryTreeFromPreorderAndInorderTraversal{
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (inorder == null || inorder.length == 0) {
        return null;
      }
      HashMap<Integer, Integer> map = new HashMap<>();
      int len = inorder.length;
      for (int i = 0; i < len; i++) {
        map.put(inorder[i], i);
      }
      return build(preorder, 0, len - 1, inorder, 0, len - 1, map);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> map) {
      if (ps > pe) {
        return null;
      }

      TreeNode root = new TreeNode(preorder[ps]);
      Integer ind = map.get(preorder[ps]);

      root.left = build(preorder,ps + 1, ps + ind - is, inorder, is, ind - 1, map);
      root.right = build(preorder, pe - ie + ind + 1, pe, inorder, ind + 1, ie, map);
      return root;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


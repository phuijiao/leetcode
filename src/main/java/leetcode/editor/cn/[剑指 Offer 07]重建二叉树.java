// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
// preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 276 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;

/**
 * @author phuijiao
 * @date 2020-12-26 13:35:55
 */
class ZhongJianErChaShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    // 用map存储中序遍历的元素及其下标，使用递归，将其拆为左子树的遍历和右子树的遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
      }

      return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    // 前序遍历 preorder =[3,9,20,15,7]
    // 中序遍历 inorder = [9,3,15,20,7]
    private TreeNode buildTree(
        int[] preorder,
        int pStart,
        int pEnd,
        int[] inorder,
        int iStart,
        int iEnd,
        HashMap<Integer, Integer> map) {
      if (pStart > pEnd) {
        return null;
      }
      TreeNode root = new TreeNode(preorder[pStart]);
      Integer ino = map.get(preorder[pStart]);

      root.left =
          buildTree(preorder, pStart + 1, pStart + ino - iStart, inorder, iStart, ino - 1, map);
      root.right =
          buildTree(preorder, pStart + ino - iStart + 1, pEnd, inorder, ino + 1, iEnd, map);
      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

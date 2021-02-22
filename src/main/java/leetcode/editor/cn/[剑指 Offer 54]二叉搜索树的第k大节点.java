//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 107 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-01-21 11:18:33
 */

class ErChaSouSuoShuDeDiKdaJieDianLcof{
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
    int k, res;
    public int kthLargest(TreeNode root, int k) {
      this.k = k;
      dfs(root);
      return res;
    }

    private void dfs(TreeNode root) {
      if (root == null) {
        return;
      }
      dfs(root.right);
      if (k == 0) {
        return;
      }
      if (--k == 0) {
        res = root.val;
      }
      dfs(root.left);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


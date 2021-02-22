// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
// 示例:
// 给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
// ]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
// Related Topics 树 深度优先搜索
// 👍 110 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phuijiao
 * @date 2020-12-12 20:37:15
 */
class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);

    solution.pathSum(root, 22);
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
  class Solution {
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      recur(root, sum);
      return res;
    }

    private void recur(TreeNode root, int tar) {
      if (root == null) {
        return;
      }
      path.add(root.val);
      tar -= root.val;
      if (tar == 0 && root.left == null && root.right == null) {
        res.add(new LinkedList<Integer>(path));
      }
      recur(root.left, tar);
      recur(root.right, tar);
      path.removeLast();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

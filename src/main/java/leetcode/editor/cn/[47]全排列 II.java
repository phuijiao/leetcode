//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 643 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-03-25 10:55:51
 */

class PermutationsIi{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
      res = new ArrayList<>();
      this.nums = nums;
      if (nums == null || nums.length == 0) {
        return res;
      }
      recur(0);
      return res;
    }

    private void recur(int ind) {
      int len = nums.length;
      if (ind == len) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
          list.add(nums[i]);
        }
        res.add(list);
      }
      HashSet<Integer> set = new HashSet<>();
      for (int i = ind; i < len; i++) {
        if (!set.add(nums[i])) {
          continue;
        }
        swap(ind, i);
        recur(ind + 1);
        swap(ind, i);
      }
    }

    private void swap(int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}


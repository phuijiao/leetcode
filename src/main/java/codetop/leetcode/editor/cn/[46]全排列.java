
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1485 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
  * @author  phuijiao
  * @date 2021-08-08 22:46:55
  */

class Permutations {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
      res = new ArrayList<>();
      permute(nums, 0);
      return res;
    }

    private void permute(int[] nums, int ind) {
      int len = nums.length;
      if (ind == len) {
        ArrayList<Integer> tmp = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
          tmp.add(nums[i]);
        }
        res.add(tmp);
      }
      for (int i = ind; i < len; i++) {
        swap(nums, ind, i);
        permute(nums, ind + 1);
        swap(nums, ind, i);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}
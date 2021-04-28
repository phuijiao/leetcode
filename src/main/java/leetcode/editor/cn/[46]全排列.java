//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1239 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author  phuijiao
 * @date 2021-03-25 10:52:51
 */

class Permutations{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
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
      for (int i = ind; i < len; i++) {
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


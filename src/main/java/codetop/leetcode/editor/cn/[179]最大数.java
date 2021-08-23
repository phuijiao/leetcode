
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 765 👎 0

package codetop.leetcode.editor.cn;

import java.util.Arrays;

/**
  * @author  phuijiao
  * @date 2021-08-21 11:09:22
  */

class LargestNumber {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
      StringBuilder builder = new StringBuilder();
      Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).forEach(builder::append);
      int ind = 0;
      while (ind < builder.length() - 1) {
        if (builder.charAt(ind) != '0') {
          break;
        }
        ind++;
      }
      builder.delete(0, ind);
      return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
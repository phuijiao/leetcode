
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 878 👎 0

package codetop.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author phuijiao
 * @date 2021-08-20 11:53:54
 */

class LongestConsecutiveSequence {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestConsecutive1(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int len = nums.length;
      Arrays.sort(nums);
      int max = 0;
      int count = 1, right = 1;
      while (right < len) {
        if (nums[right - 1] == nums[right]) {
        } else if (nums[right - 1] + 1 == nums[right]) {
          count++;
        } else {
          max = Math.max(max, count);
          count = 1;
        }
        right++;
      }
      max = Math.max(max, count);
      return max;
    }


    public int longestConsecutive(int[] nums) {
      int len = nums.length;
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < len; i++) {
        set.add(nums[i]);
      }
      int num, length, max = 0;
      for (int i = 0; i < len; i++) {
        num = nums[i];
        if (!set.contains(num - 1)) {
          length = 1;
          while (set.contains(++num)) {
            length++;
          }
          max = Math.max(max, length);
        }
      }
      return max;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
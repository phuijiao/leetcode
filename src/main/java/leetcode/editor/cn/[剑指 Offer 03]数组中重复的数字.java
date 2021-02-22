// 找出数组中重复的数字。
//
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
// 找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
// [2, 3, 1, 0, 2, 5, 3]
// 输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 237 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;

/**
 * @author phuijiao
 * @date 2020-12-26 10:31:22
 */
class ShuZuZhongZhongFuDeShuZiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 利用set集合的非重复性，add重复的元素时返回false
    public int findRepeatNumber1(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for (int num : nums) {
        if (!set.add(num)) {
          return num;
        }
      }
      return 0;
    }

    // nums数组元素在0到n-1之间，使用长度为n的标志位数组，默认值为false，判断flag[num]为true则返回num，否则flag[num]设置为true
    public int findRepeatNumber(int[] nums) {
      int len = nums.length;
      boolean[] flag = new boolean[len];
      for (int num : nums) {
        if (flag[num]) {
          return num;
        } else {
          flag[num] = true;
        }
      }
      return -1;
    }

    // 若要空间复杂度为1，可使用双层循环比较，或冒泡比较

  }
  // leetcode submit region end(Prohibit modification and deletion)

}

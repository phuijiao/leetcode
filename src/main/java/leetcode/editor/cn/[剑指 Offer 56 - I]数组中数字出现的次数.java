// 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,4,6]
// 输出：[1,6] 或 [6,1]
//
//
// 示例 2：
//
// 输入：nums = [1,2,10,4,1,4,3,3]
// 输出：[2,10] 或 [10,2]
//
//
//
// 限制：
//
//
// 2 <= nums.length <= 10000
//
//
//
// 👍 271 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;

/**
 * @author phuijiao
 * @date 2020-12-19 17:11:34
 */
class ShuZuZhongShuZiChuXianDeCiShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    //set集合非重复
    public int[] singleNumbers1(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for (int num : nums) {
        if (set.contains(num)) {
          set.remove(num);
        } else {
          set.add(num);
        }
      }
      return set.stream().mapToInt(Integer::intValue).toArray();
    }

    //异或法
    public int[] singleNumbers(int[] nums) {
      int xor = 0;
      for (int num : nums) {
        xor ^= num;
      }
      int diff = 1;
      while ((xor & diff) == 0) {
        diff <<= 1;
      }
      int a = 0, b = 0;
      for (int num : nums) {
        if ((num & diff) == 0) {
          a ^= num;
        } else {
          b ^= num;
        }
      }
      return new int[] {a, b};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
//
//
// 示例 1：
//
// 输入：nums = [3,4,3,3]
// 输出：4
//
//
// 示例 2：
//
// 输入：nums = [9,1,7,9,7,9,7]
// 输出：1
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10000
// 1 <= nums[i] < 2^31
//
//
//
// 👍 107 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author phuijiao
 * @date 2020-12-19 19:18:20
 */
class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int singleNumber1(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
          return entry.getKey();
        }
      }
      return 0;
    }

    public int singleNumber(int[] nums) {
      int x = 0, y = 0;
      for (int n : nums) {
        y = y ^ n & ~x;
        x = x ^ n & ~y;
      }
      return y;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

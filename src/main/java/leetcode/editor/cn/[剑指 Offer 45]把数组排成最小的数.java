// 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//
//
// 示例 1:
//
// 输入: [10,2]
// 输出: "102"
//
// 示例 2:
//
// 输入: [3,30,34,5,9]
// 输出: "3033459"
//
//
//
// 提示:
//
//
// 0 < nums.length <= 100
//
//
// 说明:
//
//
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
//
// Related Topics 排序
// 👍 133 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author phuijiao
 * @date 2020-12-18 22:36:26
 */
class BaShuZuPaiChengZuiXiaoDeShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String minNumber(int[] nums) {
      StringBuilder builder = new StringBuilder();
      Arrays.stream(nums)
          .mapToObj(String::valueOf)
          .sorted((a, b) -> (a + b).compareTo(b + a))
          .forEach(builder::append);
      return builder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

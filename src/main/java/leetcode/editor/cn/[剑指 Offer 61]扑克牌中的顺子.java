//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

/**
 * @author  phuijiao
 * @date 2021-02-24 10:54:32
 */

class BuKePaiZhongDeShunZiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      int count = 0;
      for (int num : nums) {
        if (num == 0) {
          continue;
        }
        max = Math.max(max, num);
        min = Math.min(min, num);
        if (!set.add(num)) {
          return false;
        }
      }

      return (max - min) <= 4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


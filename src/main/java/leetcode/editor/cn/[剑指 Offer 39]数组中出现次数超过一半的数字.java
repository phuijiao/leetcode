//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 105 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  phuijiao
 * @date 2021-01-19 10:51:24
 */

class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //数组排序，中间位置即是
    public int majorityElement1(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length/2];
    }


    //寻找中位数
    public int majorityElement2(int[] nums) {
      PriorityQueue<Integer> min = new PriorityQueue<>();
      PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> y - x);

      for (int num : nums) {
        if (min.size() == max.size()) {
          min.add(num);
          max.add(min.poll());
        } else {
          max.add(num);
          min.add(max.poll());
        }
      }
      return max.peek();
    }


    //摩尔投票法
    public int majorityElement(int[] nums) {
      int sum = 0;
      int tar = nums[0];
      for (int i = 0; i < nums.length; i++) {
        if (sum == 0) {
          tar = nums[i];
        }
        sum += nums[i] == tar ? 1 : -1;
      }
      return tar;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


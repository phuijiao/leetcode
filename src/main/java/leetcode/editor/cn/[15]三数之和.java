//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3094 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author  phuijiao
 * @date 2021-03-17 10:02:57
 */

class ThreeSum{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //超时
    public List<List<Integer>> threeSum1(int[] nums) {
      if (nums == null || nums.length < 3) {
        return new ArrayList<>();
      }

      HashSet<List<Integer>> res = new HashSet<>();
      Arrays.sort(nums);
      int len = nums.length;
      for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
          for (int k = j + 1; k < len; k++) {
            if (nums[i] + nums[j] + nums[k] == 0) {
              ArrayList<Integer> list = new ArrayList<>();
              list.add(nums[i]);
              list.add(nums[j]);
              list.add(nums[k]);
              res.add(list);
              break;
            }
          }
        }
      }
      return new ArrayList<>(res);
    }

/////////////////////////////////////////////////////////
    public List<List<Integer>> threeSum(int[] nums) {
      ArrayList<List<Integer>> res = new ArrayList<>();
      if (nums == null || nums.length < 3) {
        return res;
      }
      Arrays.sort(nums);
      int len = nums.length;
      for (int i = 0; i < len - 2; i++) {
        if (nums[i] > 0){
          break;
        }
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        int left = i + 1, right = len - 1;
        int target = -nums[i];
        while (left < right) {
          if (nums[left] + nums[right] == target) {
            res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          } else if (nums[left] + nums[right] < target) {
            left++;
          } else {
            right--;
          }
        }
      }
      return res;
    }




  }
//leetcode submit region end(Prohibit modification and deletion)

}



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
// Related Topics 数组 双指针 排序 
// 👍 3606 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * @author  phuijiao
  * @date 2021-08-08 11:33:54
  */

class ThreeSum {
  public static void main(String[] args) {
    Solution solution = new Solution();
//    List<Integer> list = Arrays.asList(1, 2, 3);
//    System.out.println(list);
//    int[] arr = {-1,0,1,2,-1,-4};
//    solution.threeSum(arr);
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
      res = new ArrayList<>();
      int len = nums.length;
      if (len < 3) {
        return res;
      }
      Arrays.sort(nums);

      for (int i = 0; i < len - 2; i++) {
        if (nums[i] > 0) {
          break;
        }
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        int left = i + 1, right = len - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          if (sum == 0) {
            res.add(Arrays.asList(nums[i], nums[left], nums[right]));
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          } else if (sum < 0) {
            left++;
          } else {
            right--;
          }
        }
      }

      return res;
    }

//    private void threeSum(int[] nums, int start, int end) {
//
//      int ind = 0;
//      while (start < end - 1) {
//        if (nums[start] > 0 || nums[end] < 0
//                || (nums[start] == 0 && nums[end] > 0)
//                || (nums[end] == 0 && nums[start] < 0)) {
//          return;
//        }
//        search(nums, start, end);
//        while (start < end - 1 && nums[start] == nums[start + 1]) {
//          start++;
//        }
//        while (start < end - 1 && nums[end] == nums[end - 1]) {
//          end--;
//        }
////        search(nums, start, end);
//        search(nums, start + 1, end);
//        search(nums, start, end - 1);
//        start++;
//        end--;
//      }
//    }
//
//
//    private static void search(int[] nums, int start, int end) {
//      int i = start + 1, j = end - 1, mid, sum;
//
//      while (i <= j) {
//        mid = (i + j) >> 1;
//        sum = nums[start] + nums[mid] + nums[end];
//        if (sum == 0) {
//          res.add(Arrays.asList(nums[start], nums[mid], nums[end]));
//          break;
//        } else if (sum < 0) {
//          i = mid + 1;
//        } else {
//          j = mid - 1;
//        }
//      }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
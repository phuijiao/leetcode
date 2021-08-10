
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 337 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-07 21:39:52
  */

class SortAnArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
      fastSort(nums, 0, nums.length - 1);
      return nums;
    }

    private void fastSort(int[] nums, int start, int end) {
      if (start >= end) {
        return;
      }
      int tmp = nums[start];
      int i = start, j = end;
      while (i < j) {
        while (i < j && tmp <= nums[j]) {
          j--;
        }
        nums[i] = nums[j];

        while (i < j && nums[i] <= tmp) {
          i++;
        }
        nums[j] = nums[i];
      }
      nums[i] = tmp;
      fastSort(nums, start, i - 1);
      fastSort(nums, i + 1, end);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
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
// 👍 239 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-21 14:21:19
 */

class SortAnArray{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
      int len = nums.length;
      fastSort(nums, 0, len - 1);
      return nums;
    }

    private void fastSort(int[] nums, int start, int end) {
      if (start >= end) {
        return;
      }
      int tmp = nums[start];
      int i = start, j = end;
      while (i < j) {
        while (i < j) {
          if (nums[j] < tmp) {
            nums[i] = nums[j];
            break;
          } else {
            j--;
          }
        }
        while (i < j) {
          if (nums[i] > tmp) {
            nums[j] = nums[i];
            break;
          } else {
            i++;
          }
        }
      }
      nums[i] = tmp;
      fastSort(nums, start, i - 1);
      fastSort(nums, i + 1, end);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


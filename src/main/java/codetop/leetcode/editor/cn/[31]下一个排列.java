
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1269 👎 0

package codetop.leetcode.editor.cn;



/**
 * @Author phuijiao
 * @date 2021-08-12 21:09:42
 */
 
class NextPermutation {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    reverse(nums, i + 1, len - 1);
                    return;
                }
            }
        }
        sort(nums, 0, len -1);
    }

      private void reverse(int[] nums, int i, int j) {
        int tmp;
          while (i < j) {
              tmp = nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
              i++;
              j--;
          }
      }

      private void sort(int[] nums, int start, int end) {
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
          sort(nums, start, i - 1);
          sort(nums, i + 1, end);
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}

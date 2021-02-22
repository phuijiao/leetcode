// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
//
//
// 示例：
//
// 输入：nums = [1,2,3,4]
// 输出：[1,3,2,4]
// 注：[3,1,2,4] 也是正确的答案之一。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10000
//
// 👍 71 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 16:29:23
 */
class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] exchange1(int[] nums) {
      if (nums == null || nums.length < 2) {
        return nums;
      }
      int i = 0, j = nums.length - 1;
      int tmp;
      while (i < j) {
        while (i < j) {
          if ((nums[i] & 1) == 0) {
            break;
          } else {
            i++;
          }
        }
        while (i < j) {
          if ((nums[j] & 1) == 0) {
            j--;
          } else {
            break;
          }
        }
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
      }
      return nums;
    }

    public int[] exchange(int[] nums) {
      int left = 0, right = nums.length - 1, tmp;

      while (left < right) {
        if ((nums[left] & 1) != 0) {
          left++;
          continue;
        }
        if ((nums[right] & 1) != 1) {
          right--;
          continue;
        }
        tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        left++;
        right--;
        //        swap(nums[left++], nums[right--]);
      }
      return nums;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

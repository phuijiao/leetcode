//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 88 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-01-20 20:26:39
 */

class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search1(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int len = nums.length;
      if (len == 1) {
        if (nums[0] == target) {
          return 1;
        } else {
          return 0;
        }
      }
      int left = 0, right = len - 1;
      int mid = 0;
      while (left <= right) {
        mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
          break;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      if (nums[mid] != target) {
        return 0;
      }
      left = mid;
      while (left >= 0) {
        if (nums[left] != target) {
          break;
        }
        left--;
      }
      right = mid;
      while (right < len) {

        if (nums[right] != target) {
          break;
        }
        right++;
      }
      return right - left - 1;
    }

    public int search(int[] nums, int target) {
      //搜索右边界 right
      int i = 0, j = nums.length - 1;
      while (i <= j) {
        int m = (i + j) / 2;
        if (nums[m] <= target) {
          i = m + 1;
        } else {
          j = m - 1;
        }
      }
      int right = i;
      // 若数组中无target，则提前返回
      if (j >= 0 && nums[j] != target) {
        return 0;
      }

      //搜索左边界 left
      i = 0;
      j = nums.length - 1;
      while (i <= j) {
        int m = (i + j) / 2;
        if (nums[m] < target) {
          i = m + 1;
        } else {
          j = m - 1;
        }
      }

      int left = j;
      return right - left - 1;
    }
  }

//leetcode submit region end(Prohibit modification and deletion)

}


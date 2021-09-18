//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 215 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-02-23 10:43:48
 */

class HeWeiSdeLianXuZhengShuXuLieLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.findContinuousSequence(9);
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence1(int target) {
      List<int[]> res = new ArrayList<>();
      int sum = 0;
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 1; i <= target / 2 + 1; i++) {
        sum += i;
        list.add(i);
        if (sum == target) {
          res.add(list2arr(list));
        } else if (sum > target) {
          while (sum > target) {
            Integer first = list.removeFirst();
            sum -= first;
          }
          if (sum == target) {
            res.add(list2arr(list));
          }
        }
      }
      return res.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence(int target) {
      List<int[]> res = new ArrayList<>();
      int sum = 0;
      for (int l = 1, r = 2; l < r;) {
        sum = (l + r ) * (r - l + 1) / 2;
        if (sum == target) {
          int[] ints = new int[r - l + 1];
          for (int i = l; i <= r; i++) {
            ints[i - l] = i;
          }
          res.add(ints);
          l++;
          r++;
        } else if (sum > target) {
          l++;
        } else {
          r++;
        }
      }
      return res.toArray(new int[0][]);
    }

    private int[] list2arr(LinkedList<Integer> list) {
      int size = list.size();
      int[] arr = new int[size];
      for (int i = 0; i < size; i++) {
        arr[i] = list.get(i);
      }
      return arr;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}


//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 180 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  phuijiao
 * @date 2021-01-19 11:23:40
 */

class ZuiXiaoDeKgeShuLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
      if (arr == null || arr.length == 0 || k <= 0) {
        return new int[0];
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
      for (int i = 0; i < k; i++) {
        queue.add(arr[i]);
      }
      for (int i = k; i < arr.length; i++) {
        if (queue.peek() > arr[i]) {
          queue.poll();
          queue.add(arr[i]);
        }
      }
      int[] res = new int[k];
      for (int i = 0; i < k; i++) {
        res[i] = queue.poll();
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


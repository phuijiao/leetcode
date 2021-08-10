
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 915 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author phuijiao
 * @date 2021-04-29 08:58:53
 */

class MergeIntervals {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge1(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
      queue.add(intervals[0]);
      for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= queue.peek()[1]) {
          if (intervals[i][1] > queue.peek()[1]) {
            queue.peek()[1] = intervals[i][1];
          }
        } else {
          queue.add(intervals[i]);
        }
      }
      return queue.toArray(new int[0][]);
    }

    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      ArrayList<int[]> queue = new ArrayList<>();
      queue.add(intervals[0]);
      for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= queue.get(queue.size() - 1)[1]) {
          if (intervals[i][1] > queue.get(queue.size() - 1)[1]) {
            queue.get(queue.size() - 1)[1] = intervals[i][1];
          }
        } else {
          queue.add(intervals[i]);
        }
      }
      return queue.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

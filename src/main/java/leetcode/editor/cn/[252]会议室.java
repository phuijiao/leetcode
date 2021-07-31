
//给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判
//断一个人是否能够参加这里面的全部会议。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti < endi <= 106 
// 
// Related Topics 排序 
// 👍 64 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author  phuijiao
 * @date 2021-03-23 18:53:27
 */

class MeetingRooms{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
        return true;
      }
      int len = intervals.length;
      if (len == 1) {
        return true;
      }
      Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
      for (int i = 1; i < len; i++) {
        if (intervals[i][0] < intervals[i - 1][1]) {
          return false;
        }
      }
      return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


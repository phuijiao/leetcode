
// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
// ] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
// 输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
// 输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
// ted-array-ii/
// Related Topics 二分查找
// 👍 193 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 15:08:23
 */
class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minArray(int[] numbers) {
      int len = numbers.length;
      int pre = 0, post = len - 1;

      while (pre < post) {
        int mid = pre + (post - pre) / 2;
        if (numbers[mid] < numbers[post]) {
          post = mid;
        } else if (numbers[mid] > numbers[post]) {
          pre = mid + 1;
        } else {
          post -= 1;
        }
      }
      return numbers[pre];
    }

    // 单调递增是遇到较小数
    public int minArray2(int[] numbers) {
      int len = numbers.length;
      if (len == 1) {
        return numbers[0];
      } else if (numbers[0] < numbers[len - 1]) {
        return numbers[0];
      }

      int i = 0;
      for (i = 0; i < len - 1; i++) {
        if (numbers[i + 1] < numbers[i]) {
          return numbers[i + 1];
        }
      }
      return numbers[i];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

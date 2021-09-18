
// 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i
// +1]×…×A[n-1]。不能使用除法。
//
//
//
// 示例:
//
// 输入: [1,2,3,4,5]
// 输出: [120,60,40,30,24]
//
//
//
// 提示：
//
//
// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
//
// 👍 68 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-22 09:56:31
 */
class GouJianChengJiShuZuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] constructArr1(int[] a) {
      int length = a.length;
      int[] res = new int[length];
      for (int i = 0; i < length; i++) {
        int sum = 1;
        for (int j = 0; j < length; j++) {
          if (i != j) {
            sum *= a[j];
          }
        }
        res[i] = sum;
      }
      return res;
    }

    public int[] constructArr(int[] a) {
      if (a.length == 0) {
        return new int[0];
      }
      int[] b = new int[a.length];
      b[0] = 1;
      int tmp = 1;
      for (int i = 1; i < a.length; i++) {
        b[i] = b[i - 1] * a[i - 1];
      }
      for (int i = a.length - 2; i >= 0; i--) {
        tmp *= a[i + 1];
        b[i] *= tmp;
      }
      return b;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}

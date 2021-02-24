// 有n块宽度为1，高度为height[]的木板依次并排排列，在多块木板的凹处会有积水区域，求最大积水量区域及积水量
package Demo;

/** @Author jiaopenghui @Date 2020/12/29 3:42 下午 */
public class ShortBoard {

  public int mothed(int[] height) {
    int len = height.length;
    if (len < 3) {
      return 0;
    }
    int left = 0, max = 0, cap = 0;
    for (int i = 1; i < len; i++) {
      if (height[i] < height[left]) {
        cap += height[left] - height[i - 1];
      } else {
        max = Math.max(max, cap);
        left = i;
        cap = 0;
      }
    }
    cap = 0;
    int right = len - 1;
    for (int i = len - 2; i >= 0; i--) {
      if (height[i] < height[right]) {
        cap += height[right] - height[i];
      } else {
        max = Math.max(max, cap);
        right = i;
        cap = 0;
      }
    }
    return max;
  }
}

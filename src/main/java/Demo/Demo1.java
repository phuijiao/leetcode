package Demo;

/**
 * @Author jiaopenghui
 * @Date 2021/1/28 10:45 上午
 */
public class Demo1 {

  //题目一：整数中包含1的个数
  public int allOne(int num) {
    int bits = 1; //个十百
    int res = 0;
    int high = num / 10;
    int cur = num % 10;
    int low = 0;

    while (high != 0 || cur != 0) {
      if (cur == 0) {
        res += high * bits;
      } else if (cur == 1) {
        res += high * bits + low + 1;
      } else {
        res += (high + 1) * bits;
      }
      low += cur * bits;
      cur = high % 10;
      high /= 10;
      bits *= 10;
    }
    return res;
  }


  //题目二：两个字符串的最小编辑距离
  public int minDistance(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return 0;
    } else if (str1 == null) {
      return str2.length();
    } else if (str2 == null) {
      return str1.length();
    }

    int n = str1.length();
    int m = str2.length();

    // DP 数组
    int[][] D = new int[n + 1][m + 1];

    // 边界状态初始化
    for (int i = 0; i < n + 1; i++) {
      D[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
      D[0][j] = j;
    }

    // 计算所有 DP 值
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        int left = D[i - 1][j] + 1;
        int down = D[i][j - 1] + 1;
        int leftDown = D[i - 1][j - 1];
        if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
          leftDown += 1;
        }
        D[i][j] = Math.min(left, Math.min(down, leftDown));
      }
    }
    return D[n][m];
  }

}

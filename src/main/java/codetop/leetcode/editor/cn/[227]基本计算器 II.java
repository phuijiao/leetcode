
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 
// 👍 443 👎 0

package codetop.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author phuijiao
 * @date 2021-08-21 15:42:57
 */

class BasicCalculatorIi {
  public static void main(String[] args) {
    Solution solution = new Solution();
//    int num = solution.calculate("3+2*2");
    int num = solution.calculate("1-1+1");
    System.out.println(num);
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int calculate(String s) {
      LinkedList<Integer> nums = new LinkedList<>();
      LinkedList<Character> sign = new LinkedList<>();
      int num = 0;
      s = s + "+0";
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == ' ') {
          continue;
        } else if (ch >= '0' && ch <= '9') {
          num = num * 10 + ch - '0';
        } else {
          if (!sign.isEmpty() && sign.peekLast() == '*') {
            Integer n1 = nums.removeLast();
            num = n1 * num;
            sign.removeLast();
          } else if (!sign.isEmpty() && sign.peekLast() == '/') {
            Integer n1 = nums.removeLast();
            num = n1 / num;
            sign.removeLast();
          }
          nums.add(num);
          num = 0;
          sign.add(ch);
        }
      }
      nums.add(num);
      num = nums.removeFirst();
      while (!sign.isEmpty()) {
        Integer n1 = nums.removeFirst();
        if (sign.removeFirst() == '+') {
          num = num + n1;
        } else {
          num = num - n1;
        }
      }
      return num;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
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
// Related Topics 栈 字符串 
// 👍 395 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author phuijiao
 * @date 2021-05-18 21:28:41
 */

class BasicCalculatorIi {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.calculate("1*2-3/4+5*6-7*8+9/10");
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int calculate1(String s) {
      LinkedList<Integer> numlist= new LinkedList<>();
      LinkedList<Character> signlist = new LinkedList<>();
      int num = 0;
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == ' ') {
          continue;
        } else if (ch >= '0' && ch <= '9') {
          num = num * 10 + ch - '0';
        } else if (signlist.isEmpty() || signlist.peekLast() == '+' || signlist.peekLast() == '-') {
          numlist.addLast(num);
          num = 0;
          signlist.addLast(ch);
        } else {
          numlist.addLast(calc(num, numlist.removeLast(), signlist.removeLast()));
          num = 0;
          signlist.addLast(ch);
        }
      }
      if (!signlist.isEmpty() && (signlist.peekLast() == '*' || signlist.peekLast() == '/')) {
        num = calc(num, numlist.removeLast(), signlist.removeLast());
      }

      numlist.addLast(num);
      num = numlist.removeFirst();
      while (!signlist.isEmpty()) {
        num = calc(numlist.removeFirst(), num, signlist.removeFirst());
      }
      return num;
    }

    private Integer calc(Integer n2, Integer n1, Character sign) {
      switch (sign) {
        case '+' : return n1 + n2;
        case '-' : return n1 - n2;
        case '*' : return n1 * n2;
        case '/' : return n1 / n2;
        default : return 0;
      }
    }


    public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
      int len = s.length();
      char preSign = '+';
      int num = 0;
      for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
          num = num * 10 + ch - '0';
        }
        if (!Character.isDigit(ch) && ch != ' ' || i == len - 1) {
          switch (preSign) {
            case '+' :
              stack.push(num);
              break;
            case '-':
              stack.push(-num);
              break;
            case '*':
              stack.push(stack.pop() * num);
              break;
            default:
              stack.push(stack.pop() / num);
              break;
          }
          num = 0;
          preSign = ch;
        }
      }
      while (!stack.isEmpty()) {
        num += stack.pop();
      }
      return num;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
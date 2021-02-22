// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
// 功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
// ["CQueue","appendTail","deleteHead","deleteHead"]
// [[],[3],[],[]]
// 输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
// ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
// [[],[],[5],[2],[],[]]
// 输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 149 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Stack;

/**
 * @author phuijiao
 * @date 2020-12-26 14:18:10
 */
class YongLiangGeZhanShiXianDuiLieLcof {
  public static void main(String[] args) {
    CQueue solution = new CQueue();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class CQueue {
    Stack<Integer> pre;
    Stack<Integer> post;

    public CQueue() {
      pre = new Stack<>();
      post = new Stack<>();
    }

    public void appendTail(int value) {
      post.push(value);
    }

    public int deleteHead() {
      if (pre.isEmpty()) {
        while (!post.isEmpty()) {
          pre.push(post.pop());
        }
      }
      return pre.isEmpty() ? -1 : pre.pop();
    }
  }

  /**
   * Your CQueue object will be instantiated and called as such: CQueue obj = new CQueue();
   * obj.appendTail(value); int param_2 = obj.deleteHead();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}

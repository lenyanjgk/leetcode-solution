//138 随机链表的复制
//2024-10-01 21:44:33

  package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer{
      public static void main(String[] args) {
           Solution solution = new CopyListWithRandomPointer().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

      class Solution {
          public Node copyRandomList(Node head) {
              if(head == null) return null;
              Node cur = head;
              Map<Node, Node> map = new HashMap<>();
              // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
              while(cur != null) {
                  map.put(cur, new Node(cur.val));
                  cur = cur.next;
              }
              cur = head;
              // 4. 构建新链表的 next 和 random 指向
              while(cur != null) {
                  map.get(cur).next = map.get(cur.next);
                  map.get(cur).random = map.get(cur.random);
                  cur = cur.next;
              }
              // 5. 返回新链表的头节点
              return map.get(head);
          }
      }


//leetcode submit region end(Prohibit modification and deletion)

  }
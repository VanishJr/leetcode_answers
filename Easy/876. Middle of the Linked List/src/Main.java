public class Main {
    public static void main(String[] args) {

    }
}


class ListNode {
      int val;
      ListNode next;

      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        int length = 0;

        while(currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        length = (int) Math.ceil(length / 2);

        for (int i = 0; i < length; i++) {
            head = head.next;
        }

        return head;
    }
}
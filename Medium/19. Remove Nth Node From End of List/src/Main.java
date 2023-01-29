public class Main {
    public static void main(String[] args) {

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;

        ListNode node1 = head;
        ListNode node2 = head;

        int len = 0;

        while(node1 != null)
        {
            len++;
            node1 = node1.next;
        }

        int index = len - n;
        node1 = head;

        boolean start = false;

        while(true)
        {
            if(index == 0)
            {
                if(node1 == head)
                {
                    node2 = node2.next;
                    node1.next = null;
                    head = node2;
                    break;
                }

                else
                {
                    node2.next = node1.next;
                    node1.next = null;
                    break;
                }
            }

            index--;

            if(start)
                node2 = node2.next;

            start = true;

            node1 = node1.next;
        }

        return head;
    }
}
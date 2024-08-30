package tpr.leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public class LinkedList {
     /**
      * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
      *
      * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      * Input: l1 = [2,4,3], l2 = [5,6,4]
      * Output: [7,0,8]
      * Explanation: 342 + 465 = 807.
      * Example 2:
      *
      * Input: l1 = [0], l2 = [0]
      * Output: [0]
      * Example 3:
      *
      * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
      * Output: [8,9,9,9,0,0,0,1]
      * @param l1
      * @param l2
      * @return
      */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        double a = 0;
        List<Integer> list = new ArrayList<>();
        while(l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        for(int j=0; j<list.size(); j++) {
            a += list.get(list.size() - j - 1) * Math.pow(10, list.size() - 1 - j);
        }
        list.clear();
        while(l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        for(int j=0; j<list.size(); j++) {
            a += list.get(list.size() - j - 1) * Math.pow(10, list.size() - 1 - j);
        }
        ListNode ans;
        if(a > 0)
            ans = new ListNode((int) (a%10));
        else
            return new ListNode(0);
        a = (int) (a/ 10);
        ListNode fin = ans;
        while(a > 0) {
            ans.next = new ListNode((int) (a%10));
            a = (int) (a/ 10);
            ans = ans.next;
        }
        return fin;
    }
}

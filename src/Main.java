/**
 * Created by Vishal_Mukta on 12/21/2018.
 */

import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter first list of numbers:");
        ListNode list1 = getListFromInput(reader.nextLine());
        System.out.println("Enter second list of numbers (count must be same as before):");
        ListNode list2 = getListFromInput(reader.nextLine());

        ListNode list = addTwoNumbers(list1, list2);
        System.out.println("Sum list:");
        printList(list);
    }

    private static ListNode getListFromInput(String line) {
        String[] words = line.split(" ");
        ListNode head = null, n = null;
        System.out.println("List entered:");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int num = Integer.valueOf(words[i]);
                if (head == null) {
                    System.out.print(num);
                    n = new ListNode(num);
                    head = n;
                } else {
                    System.out.print(" -> " + num);
                    n.next = new ListNode(num);
                    n = n.next;
                }
            }
        }
        System.out.println();
        return head;
    }

    private static void printList(ListNode list) {
        System.out.print(list.val);
        while (list.next != null) {
            list = list.next;
            System.out.print(" -> " + list.val);
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
/*
        ListNode ll1 = l1, ll2 = l2;
        int size = 0;
        while ((ll1 != null) || (ll2 != null)) {
            ll1 = (ll1 != null) ? ll1.next : null;
            ll2 = (ll2 != null) ? ll2.next : null;
            size++;
        }
        ListNode listArray[] = new ListNode[size + 1];
*/
        int res = l1.val + l2.val;
        int r = res / 10;
        res %= 10;
        ListNode result = new ListNode(res);
        ListNode c = result;
        l1 = l1.next;
        l2 = l2.next;
//        int i = 0;
        while ((l1 != null) || (l2 != null)) {
            res = (l1 == null) ? l2.val + r : ((l2 == null) ? l1.val + r : l1.val + l2.val + r);
            r = res / 10;
            res %= 10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
//            listArray[i].val = res;
            c.next = new ListNode(res);
            c = c.next;
//            i++;
        }
        if (r > 0) {
//            listArray[i].val = r;
            c.next = new ListNode(r);
        }
        return result;
    }
}

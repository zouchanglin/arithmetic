package link_inverted_order;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedListOrder {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) return new ArrayList<>();
        Stack<Integer> integerStack = new Stack<>();
        while(listNode != null){
            integerStack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!integerStack.empty()){
            list.add(integerStack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ArrayList<Integer> integers = new LinkedListOrder().printListFromTailToHead(listNode);
        for (Integer i: integers) System.out.println(i);
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

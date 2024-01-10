package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class MergeLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    public static void main(String[] args) throws Exception{
        MergeLists.ListNode list1 = new MergeLists().new ListNode();
        list1.val = 1;
        list1.next = new MergeLists().new ListNode();
        list1.next.val = 2;
        list1.next.next = new MergeLists().new ListNode();
        list1.next.next.val = 4;

        MergeLists.ListNode list2 = new MergeLists().new ListNode();
        list2.val = 1;
        list2.next = new MergeLists().new ListNode();
        list2.next.val = 3;
        list2.next.next = new MergeLists().new ListNode();
        list2.next.next.val = 5;
        list2.next.next.next = new MergeLists().new ListNode();
        list2.next.next.next.val = 7;

        mergeTwoLists(list1, list2);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ArrayList<Integer> arr = new ArrayList<>();
        while(list1 != null){
            arr.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            arr.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(arr);
        for(int i = 0 ; i < arr.size() ; i++){
            ListNode head = result;
            ListNode newNode = new MergeLists().new ListNode(arr.get(i), null);
            if(result == null){
                result = newNode;
            }else{
                while(head.next != null){
                    head = head.next;
                }
                head.next = newNode;
            }
        }
        return result;   
    }
}


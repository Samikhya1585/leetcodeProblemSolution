/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first=-1;
        int prevCritical=-1;

        int minDist=Integer.MAX_VALUE;
        int maxDist=-1;

        int pos=1;

        ListNode prev=head;
        ListNode curr=head.next;

        while(curr!=null && curr.next!=null){
            ListNode next=curr.next;

            if((curr.val>prev.val && curr.val>next.val)||(curr.val<prev.val && curr.val<next.val)){

                if(first==-1){
                    first=pos;
                }

                if(prevCritical!=-1){
                    minDist=Math.min(minDist,pos-prevCritical);

                    maxDist=pos-first;
                }
                prevCritical=pos;
            }

            prev=curr;
            curr=curr.next;
            pos++;
        }

        if(minDist==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }

        return new int[]{minDist,maxDist};

        
    }
}
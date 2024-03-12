class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        
        HashMap<Integer, ListNode> track = new HashMap<>();
        
        int sum = 0;
        
        while (head != null) {
            
            sum += head.val;
            
            if (track.containsKey(sum)) {
                ListNode start = track.get(sum);
                head = start.next;
                
                int p = sum + head.val;
                
                while (p != sum) {
                    track.remove(p);
                    head = head.next;
                    p += head.val;
                }
                
                start.next = head.next;
            } else {
                track.put(sum, head);
            }
            
            head = head.next;
        }
        
        return dummy.next;
        
    }
}
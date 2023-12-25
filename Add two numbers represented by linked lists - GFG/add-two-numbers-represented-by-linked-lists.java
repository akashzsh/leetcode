//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends

class Solution{
    static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        
        Node dummy = new Node(0);
        Node start = dummy;
        int carry = 0;
        while (first != null || second != null || carry != 0) {
            int sum = first == null ? 0 : first.data;
            sum += second == null ? 0 : second.data;
            sum += carry;
            
            start.next = new Node(sum % 10);
            start = start.next;
            
            carry = sum / 10;
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }
        
        dummy = reverse(dummy.next);
        return dummy;
    }
}
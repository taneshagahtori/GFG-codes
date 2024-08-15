//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        Node res = head;
        if(head.next == null){
            head.data += 1;
            return head;
        }
        solve(head,head);
        return res;
        
    }
    
    private int solve(Node head,Node head2){
        if(head.next == null){
            int value = head.data;
            if(value == 9){
                head.data = 0;
                return 1;
            }
            else{
                head.data = (value+1);
            }
            return 0;
        }
        
        int carry = solve(head.next,head2);
        int curr = head.data;
        if(head == head2 && carry ==1 && curr == 9){
            head.data = 10;
            return 0;
        }
        if(carry == 1 && curr == 9){
            head.data = 0;
            return 1;
        }
        else if(carry ==1 && curr < 9){
            head.data = (curr+1);
        }
        return 0;
        
    }
}
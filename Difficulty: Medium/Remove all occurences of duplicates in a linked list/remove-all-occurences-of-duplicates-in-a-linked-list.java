//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


 

class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        if (head == null || head.next == null) {
            return head;
        }

        // Use a dummy node to handle edge cases easily
        Node dummy = new Node(0);
        dummy.next = head;

        // Use a hashmap to count occurrences of each value
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Node current = head;
        while (current != null) {
            countMap.put(current.data, countMap.getOrDefault(current.data, 0) + 1);
            current = current.next;
        }

        // Remove all nodes that have duplicates
        Node prev = dummy;
        current = head;
        while (current != null) {
            if (countMap.get(current.data) > 1) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
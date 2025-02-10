//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            if (g.isBST(root))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    class BSTPair {
        boolean isBST;
        int min;
        int max;
    }
    
    boolean isBST(Node root) {
        return isItABinaryTree(root).isBST;
    }
    
    public BSTPair isItABinaryTree(Node root) {

        if (root == null) {
            BSTPair pair = new BSTPair();
            pair.max = Integer.MIN_VALUE;
            pair.min = Integer.MAX_VALUE;
            pair.isBST = true;
            return pair;
        }

        BSTPair lp = isItABinaryTree(root.left);
        BSTPair rp = isItABinaryTree(root.right);

        BSTPair pair = new BSTPair();
        pair.isBST = lp.isBST && rp.isBST && (root.data>=lp.max && root.data<= rp.min);
        pair.max = Math.max(root.data, Math.max(lp.max, rp.max));
        pair.min = Math.min(root.data, Math.min(lp.min, rp.min));

        return pair;
    }
}
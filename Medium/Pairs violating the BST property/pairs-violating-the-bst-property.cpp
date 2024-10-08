//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// A Tree node
struct Node {
    int data;
    struct Node *left, *right;
};

// Utility function to create a new node
Node* newNode(int data) {
    Node* temp = new Node;
    temp->data = data;
    temp->left = temp->right = NULL;
    return (temp);
}

Node* buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
// User function Template for C++

/*// A Tree node
struct Node
{
    int data;
    struct Node *left, *right;
};*/

class Solution {
  public:

    /*You are required to complete below function */
    void df(Node* r, vector<int>&a){
        if (!r) return;
        df(r->left, a);
        a.push_back(r->data);
        df(r->right, a);
    }
    void me(vector<int> &a, int l, int r, int &ans){
        int m = (l+r)/2, z = l;
        queue<int> b, c;
        for (int i=l;i<=m;i++) b.push(a[i]);
        for (int i=m+1;i<=r;i++) c.push(a[i]);
        b.push(INT_MAX), c.push(INT_MAX);
        while(true){
            if (b.size()==1&&c.size()==1) break;
            if (b.front()<c.front()) a[z++] = b.front(), b.pop();
            else a[z++] = c.front(), c.pop(), ans += b.size() - 1;
        }
    }
    void s(vector<int> &a, int l, int r, int &ans){
        if (l!=r){
            int m = (l+r)/2;
            s(a,l,m,ans);
            s(a,m+1,r,ans);
            me(a,l,r, ans);
        }
    }
    int pairsViolatingBST(int n, Node *root) {
        vector<int> in;
        df(root, in);
        // calculate inversions in nlogn using merge-sort
        int ans = 0;
        s(in, 0, n-1, ans);
        return ans;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    getchar();

    while (t--) {

        int n;
        cin >> n;
        getchar();

        string inp;
        getline(cin, inp);

        struct Node* root = buildTree(inp);

        Solution ob;
        int ans = ob.pairsViolatingBST(n, root);
        cout << ans << endl;
    }

    return 0;
}
// } Driver Code Ends
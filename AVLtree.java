class Node {
    int data;
    int height;   
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.height = 1;  // height of new node is 1
        left = right = null;
    }
}

class AVL {
    Node root;

    // Height of a node
    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    // Balance factor
    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    // Right rotation
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root
        return x;
    }

    // Left rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }

    // Insert a key into AVL tree
    Node insert(Node node, int key) {
        // 1. Perform normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys not allowed

        // 2. Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Check for 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return unchanged node
        return node;
    }

    // Utility to print inorder traversal
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
}

public class AVLtree {
    public static void main(String[] args) {
        AVL tree = new AVL();   

        int[] arr = {10, 20, 30, 40, 50, 25};

        for (int i : arr)
            tree.root = tree.insert(tree.root, i); 

        System.out.println("Inorder traversal of AVL tree:");
        tree.inorder(tree.root); // should print sorted order
    }
}

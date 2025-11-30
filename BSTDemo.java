class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    // Insert node in BST
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Inorder Traversal (sorted order)
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Preorder Traversal
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Postorder Traversal
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public String Searching(Node root,int key){
        if(root==null){
            return "no data";
        }
        if(root.data==key){
            return "found in root";
    
        }
        if(key<root.data){
            return Searching(root.left,key);
        }else{
            return Searching(root.right,key);
        }


    }
    public int  findminimum(Node root){
        if(root==null){
            System.out.println("tree is empty");
            return -1;
        }
        while(root.left!=null){
            root=root.left;
        }
        return root.data;

    }
    public int  findmaximum(Node root){
        if(root==null){
            System.out.println("tree is empty");
            return -1;
        }
        while(root.right!=null){
            root=root.right;
        }
        return root.data;

    }
    public void deletebyvalue(Node root,int key){
        if(root==null){
            return;
        }
       root=null;
    }
     // Reflect the tree (mirror)
    public void reflect(Node root) {
        if (root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        reflect(root.left);
        reflect(root.right);
    }

    // Delete a node by value
    public Node deleteByValue(Node root, int value) {
        if (root == null) return null;

        if (value < root.data) {
            root.left = deleteByValue(root.left, value);
        } else if (value > root.data) {
            root.right = deleteByValue(root.right, value);
        } else {
            // Node to delete found
            if (root.left == null && root.right == null) return null; // Leaf node
            if (root.left == null) return root.right; // Only right child
            if (root.right == null) return root.left; // Only left child

            // Node with two children: get inorder successor (min in right subtree)
            int minVal = minValue(root.right);
            root.data = minVal;
            root.right = deleteByValue(root.right, minVal);
        }
        return root;
    }

    // Helper to find minimum value in a subtree
    private int minValue(Node node) {
        while (node.left != null) node = node.left;
        return node.data;
    }
}


public class BSTDemo {
    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int v : values) {
            tree.root = tree.insert(tree.root, v);
        }

        System.out.print("Inorder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preOrder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postOrder(tree.root);
        System.out.println("\nSearching for 4:"+tree.Searching(tree.root,4));
       System.out.println("Searching for 10:"+tree.Searching(tree.root,10));  
       System.out.println(" minimum value in the tree"+tree.findminimum(tree.root));
       System.out.println(" minimum value in the tree"+tree.findmaximum(tree.root));
       tree.reflect(tree.root);

        System.out.print("\nInorder after reflection: ");
        tree.inOrder(tree.root); 
           tree.root = tree.deleteByValue(tree.root, 3);
        System.out.print("Inorder after deleting 3: ");
        tree.inOrder(tree.root);
    }
}

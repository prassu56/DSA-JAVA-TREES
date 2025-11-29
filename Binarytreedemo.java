class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    // Inorder Traversal: Left → Root → Right
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Preorder Traversal: Root → Left → Right
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Postorder Traversal: Left → Right → Root
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Count total nodes
    public int countOfNode(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countOfNode(node.left) + countOfNode(node.right);
    }

    // Find height of the tree
    public int findHeightOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findHeightOfTree(node.left), findHeightOfTree(node.right));
    }

    // Sum of all nodes
    public int sumOfNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    // Sum of all leaf nodes
    public int sumOfLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
    }

    // Count all leaf nodes
    public int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // Delete entire tree
    public void deleteTree() {
        root = null;
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Build the tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // Traversals
        System.out.print("Inorder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preOrder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postOrder(tree.root);

        // Other operations
        System.out.println("\nTotal number of nodes: " + tree.countOfNode(tree.root));
        System.out.println("Height of the tree: " + tree.findHeightOfTree(tree.root));
        System.out.println("Sum of all node values: " + tree.sumOfNodes(tree.root));
        System.out.println("Sum of all leaf nodes: " + tree.sumOfLeafNodes(tree.root));
        System.out.println("Count of all leaf nodes: " + tree.countLeafNodes(tree.root));

        // Delete tree
        tree.deleteTree();
        System.out.println("Tree deleted successfully!");
    }
}

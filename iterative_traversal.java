import java.io.*;
import java.util.*;

class BinarySearchTree {

    class Node {
        int key;
        Node left;
        Node right;

        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }

    Node root;

    // constructor
    BinarySearchTree() {
        root = null;
    }

    // helper
    void insert(int key) {
        root = insertRec(root, key);
    }

    // recursively inserts to BST
    Node insertRec(Node root, int key)
    {

        // base case: return new if tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void iterativePreorder()
    {
        iterativePreorder(root);
    }

    // An iterative process to print preorder traversal of Binary tree, left then right
    void iterativePreorder(Node node)
    {

        if (node == null) {
            return;
        }

        // Push root to empty stack
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        // pop, print, push right, push left
        while (nodeStack.empty() == false) {

            Node curr = nodeStack.peek();
            System.out.println(curr.key);
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
        }
    }

    // main
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(100);
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(150);
        tree.insert(125);
        tree.insert(110);
        tree.insert(175);

        // print inorder traversal of the BST
        tree.iterativePreorder();
    }
}
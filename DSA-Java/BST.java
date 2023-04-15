import java.util.*;

public class BST{
    class Node{
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;

    void addNode(int value){
        this.root = addNode(this.root, value);
    }

    Node addNode(Node root, int value){
        if(root == null) return new Node(value);

        if(root.value > value) root.left = addNode(root.left, value);
        else if(root.value < value) root.right = addNode(root.right, value);

        return root;
    }

    void inorderPrint(){
        inorderPrint(this.root);
    }

    void inorderPrint(Node root){
        if(root == null) return;

        inorderPrint(root.left);
        System.out.println(root.value);
        inorderPrint(root.right);

    }

    void levelOrderPrint(){
        levelOrderPrint(this.root);
    }

    void levelOrderPrint(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currentNode = q.remove();

            if(currentNode == null){
                if(q.isEmpty()) return;
                q.add(null);
                System.out.println("===");
                continue;
            }

            System.out.println(currentNode.value);

            if(currentNode.left != null) q.add(currentNode.left);
            if(currentNode.right != null) q.add(currentNode.right);
        }
    }

    public static void main(String[] args){

        BST bst = new BST();
        bst.addNode(50);
        bst.addNode(30);
        bst.addNode(20);
        bst.addNode(40);
        bst.addNode(70);
        bst.addNode(60);
        bst.addNode(80);
        bst.inorderPrint();
        System.out.println("Printing Level Order");
        bst.levelOrderPrint();

    }
}

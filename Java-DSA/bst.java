public class bst{
    static class Node{
        int value;
        Node leftChild, rightChild;

        Node(int value){ 
            this.value = value; 
            leftChild = rightChild = null;
        }
    }
    static class BST{
        Node root;

        void addNode(int value){
            root = addNode(root, value);
        }
        private Node addNode(Node root, int value){
            if(root == null){
                return new Node(value);
            }

            else if(value < root.value)
                root.leftChild = addNode(root.leftChild, value);
            else if(value > root.value)
                root.rightChild = addNode(root.rightChild, value);

            return root;

        }

        void inorderPrint(){
            inorderPrint(root);
        }
        private void inorderPrint(Node root){
            if(root != null){
                inorderPrint(root.leftChild);
                System.out.println(root.value);
                inorderPrint(root.rightChild);
            }
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

    }
}

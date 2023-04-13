public class DoublyLinkedList {

    class Node{
        int value;
        Node nextNode, prevNode;

        Node(int value, Node prevNode){
            this.value = value;
            this.prevNode = prevNode;
        }
    }

    Node head;

    void addNode(int value){
        if(this.head == null){
            this.head = new Node(value, null);
            return;
        }

        Node itr = this.head;
        
        while(itr.nextNode != null){
            itr = itr.nextNode;
        }

        itr.nextNode = new Node(value, itr);
        System.out.println("Current Node Val: "+itr.nextNode.value+"\nPrev Node Value: "+itr.value);
    }

    void printList(){
        if(this.head == null){
            System.out.println("MT");
            return;
        } 
        Node itr = head;

        while(itr != null){
            System.out.println("Value"+itr.value);
            itr = itr.nextNode;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addNode(5);
        dList.addNode(1);
        dList.addNode(4);
        dList.addNode(8);

        dList.printList();

    }
    
}

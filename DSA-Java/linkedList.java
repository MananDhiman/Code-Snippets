public class linkedList{

    static class Node{
        int value;
        Node nextNode = null;
        Node(int val){ this.value = val; }
    }

    static class LinkedLis{

        Node head;

        void addNode(int val){
            Node newNode = new Node(val);
            if(this.head == null){
                this.head = newNode;
                return;
            } 
            Node itr = this.head;
            while(itr.nextNode != null){
                itr = itr.nextNode;
            }

            itr.nextNode = newNode;

        }

        void printList(){

            if(this.head == null){
                System.out.println("Empty List");
                return;
            }

            Node itr = this.head;
            while(itr.nextNode != null){
                System.out.printf("%d --> ",itr.value);
                itr = itr.nextNode;
            }

            System.out.println(itr.value);

        }

        void printListRecursively(){        
            printNode(this.head);
        }
        private void printNode(Node itr){
            if(itr == null) return;
            else if(itr.nextNode == null) {
                System.out.printf("%d",itr.value);
                return;
            }
            System.out.printf("%d --> ",itr.value);
            printNode(itr.nextNode);
        }
    }

    public static void main(String[] args){

        LinkedLis ll = new LinkedLis();
        
        ll.addNode(10);
        ll.addNode(21);
        ll.addNode(32);
        ll.addNode(43);
        ll.addNode(54);
        ll.addNode(65);
        ll.printList();
        ll.printListRecursively();
    }
}
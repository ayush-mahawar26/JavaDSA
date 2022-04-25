package LinkedLst;

public class LL {

    private Node head ;
    private Node tail ;
    
    // Add Elemnt at custom Place
    public void addAt(int val , int pos){
        Node newNode = new Node(val); 

        Node cn = head ;
        for(int i = 0 ; i < pos-1 ; i++){
            if(cn == null){
                System.out.println("You extended the value");
                return ;
            }
            cn = cn.next ; 
        }

        if(cn == head){
            Node rep = cn ; 
            head = newNode ;
            newNode.next = rep ;
            return ;
        }

        Node replaced = cn.next ;
        cn.next = newNode ;
        newNode.next = replaced ;
    }


    // Adding element at last 
    public void addLast(int val){
        
        Node newNode = new Node(val) ;
        
        if(head == null){
            head= newNode ;
            return ;
        }

        Node cn = head ; 
        while(cn.next != null){
            cn = cn.next ;
        }

        cn.next = newNode ;
        return ;
    }


    // printing all the element in LL 
    public void printLL(){
        if(head == null){
            System.out.println("No Element");
            return ;
        }

        Node cn = head ; 
        while(cn!=null){
            System.out.print(cn.val + " -> ");
            cn= cn.next ;
        }

        System.out.print(" NULL");
        System.out.println();
    }

    private class Node{
        private int val ; 
        private Node next ;

        public Node(int val){
            this.val = val ;
            this.next = null ;
        }
    }
}

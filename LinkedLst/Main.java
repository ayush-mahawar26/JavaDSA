package LinkedLst;

public class Main {
    
    public static void main(String[] args) {
        LL ll = new LL() ;

        ll.addLast(21);
        ll.addLast(91);
        ll.addLast(1);
        ll.printLL();

        ll.addAt(12, 0);
        ll.addAt(13, 3);
        ll.addAt(15, 30);
        ll.printLL();
        
    }
}

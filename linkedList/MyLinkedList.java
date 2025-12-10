package linkedList;

public class MyLinkedList {
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
    }


    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            this.addFirst(data);
        } else {
            Node newNode = new Node(data);
            size++;
            Node temp = head;

            for(int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static void Print() {
        if (head == null) {
            System.out.println("ll empty");
        } else {
            for(Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }

            System.out.println();
        }
    }
    public void removeFirst(){
        if( size ==0){
            System.out.println("ll is empty");
            return ;
        }
        else if( size ==1 ){
            head = tail = null;

        }
        head = head.next;
        size--;
    }
    public int removeLast(){
        if( size ==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if( size ==1 ){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        //prev : i= size-2
        for(int i =0; i<size-2; i++){   // hamey wo node chaiye jo last wali se ek piche , but we do -2 , since after applying this loop we do .next , so tb woh last second krdega usko
            prev = prev.next;
        }
        int val = prev.next.data;//tail ka data store krlia
        prev.next = null; // ab uska data null kia
        tail = prev;  // fir tail ko prev bna dia
        size--;        // then size reduce
        return val;     // hence returning deleted value

    }
    public int itrSearch(int key){   //O(n) linear time 
        Node temp = head;
        int i= 0;
        while(temp != null ){
            if(temp.data == key ){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper (Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
             return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    //  two function coz:-  public method simple,all recursive logic in a separate function,  flexibility (helper can take extra parameters like index, node, etc.
    public int recSearch(int key){
        return helper(head, key);
    }
    public void reverseLinkedList(){
        Node prev = null;
        Node curr =tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void deleteNthFromEnd(int n){
        Node temp = head;
        int sz = 0;
        while(temp!= null){
            temp = temp.next;
            sz++;
        }
        int i =1;
        int iToFind = sz-n;
        Node prev =  head;
        while(i< iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head){// helper function
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next; //for +1
            fast = fast.next.next; // for +2

        }
        return slow;  //slow is mid node
    }
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1 - find mid

        Node Mid = findMid(head);
        //step 2 reverse 2nd half of linked list

        Node prev = null;
        Node curr = Mid;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right= prev;// right half head , required to sart checking from another half

        //step 3 - check left half and right half same or not
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next ;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        Print();
        ll.addFirst(2);
        Print();
        ll.addFirst(1);
        Print();
        ll.addLast(3);
        Print();
        ll.addLast(4);
        Print();
        ll.addMiddle(2, 9);
        Print();
        System.out.println(size);
        ll.removeFirst();
        Print();
        ll.removeLast();
        Print();
        System.out.println(size);
        System.out.println(ll.recSearch(9));
        System.out.println(ll.itrSearch(4));
        ll.addFirst(1);
        ll.addLast(4);
        Print();
        ll.reverseLinkedList();              //reversing LL
        Print();
        ll.reverseLinkedList();
        Print();
        ll.deleteNthFromEnd(2);
        Print();
        System.out.println(ll.checkPalindrome());
        Print();


    }
}

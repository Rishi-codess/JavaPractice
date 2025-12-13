package linkedList;

public class ZigZagLL {
    static Node head;
    public static void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null ;
        Node next;
        while(curr!= null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Alternate merging
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while(left != null && right != null ){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //merging
            left = nextL;
            right = nextR;
        }

    }
    public static void main(String [] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next  = new Node(5);

        zigZag();
        Node temp = head ;
        while(temp!= null){
            System.out.print(temp.data +" ");
            temp= temp.next;
        } 

    }
}

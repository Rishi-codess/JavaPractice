package linkedList;

public class LL_part2 {
    static Node head;
    public static boolean isThereLoop(){

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; //+2
            if(slow == fast){
                return true;
            }
        }
        return false;

    }
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast ){
                isCycle = true;
                break;
            }
        }
        if (!isCycle){
            return;
        }

        // finding meeting point
        slow = head;
        Node prev = null; //this will become last node of linked list
        while (slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }
        //remove cycle -> last.next = null;
        assert prev != null;  // or if (prev != null) prev.next = null;
        prev.next = null;

    }
    public static void main(String [] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        //Ll :- 1->2->3->2
        System.out.println(isThereLoop());
        removeCycle();
        System.out.println(isThereLoop());
    }

}

package linkedList;

public class MergeSortLL {
     static Node head;
    private  static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next ;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; //+2
        }
        return slow;
    }
    private static Node merge(Node left, Node right){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(right != null && left != null){
            if(left.data <= right.data){
                temp.next = left;
                left = left.next;
            }
            else{
                temp.next = right;
                right = right.next;
            }
            temp= temp.next;
        }
        while (left != null){
            temp.next = left;
            left = left.next;
            temp= temp.next;
        }
        while (right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = findMid(head);

        // separate left part & right part
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge both the parts
        return merge( newLeft, newRight);

    }
    public static void main(String [] args){
        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(5);
        head.next.next.next.next  = new Node(4);

        head = mergeSort(head);
        Node temp = head ;
        while(temp!= null){
            System.out.print(temp.data +" ");
            temp= temp.next;
        }

    }
}

public class MainApplication {
    public static void main(String[] args) {
        ListNode laa = new ListNode(3);
        ListNode lab= new ListNode(4, laa);
        ListNode l1 = new ListNode(2, lab);

        ListNode lba = new ListNode(4);
        ListNode lbb = new ListNode(6, lba);
        ListNode l2 = new ListNode(5, lbb);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        //print off list
        while(l1!=null && l2!=null) {
            System.out.println(l1.val + ": " + l2.val);
            l1=l1.next;
            l2=l2.next;
        }
        //carry over

        return result;
    }




}

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
        ListNode result = new ListNode(0);
        int i, j;
        int sum = 0;
        int oldCarry = 0;
        int newCarry = 0;
        //print off list
        while(l1!=null && l2!=null) {
            i = l1.val;
            j = l2.val;
            sum = (i+j)>=10 ? (i+j)%10 : (i+j);
            oldCarry = (i+j)>=10 ? 1 : 0;
            result= new ListNode(sum, result);
            if(oldCarry>0){
                System.out.println(l1.val + ": " + l2.val + ": " + result.val);
                l1=l1.next;
                l2=l2.next;
                i = l1.val;
                j = l2.val;
                sum = (i+j)>=10 ? (i+j)%10 : (i+j);
                //newCarry = (i+j)>=10 ? 1 : 0; this needs to be used for another carryover
                result = new ListNode(sum+oldCarry, result);
                System.out.println(l1.val + ": " + l2.val + ": " + result.val);
                l1=l1.next;
                l2=l2.next;
            }
            else{
                System.out.println(l1.val + ": " + l2.val + ": " + result.val);
                l1=l1.next;
                l2=l2.next;
            }

        }
        //clean up needed

        return result;
    }





}

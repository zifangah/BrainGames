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

    public static int i, j, sum;
    public static int oldCarry = 0;
    public static int curCarry;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        while(l1!=null && l2!=null) {
            i = l1.val;
            j = l2.val;
            sum = (i+j)>=10 ? (i+j)%10 : (i+j);
            curCarry = (i+j)>=10 ? 1 : 0;
            result= new ListNode(sum+oldCarry, result);
            //increment oldCarry after
            if(curCarry>0){
                oldCarry++;
            }
            System.out.println(l1.val + ": " + l2.val + ": " + result.val);
            l1=l1.next;
            l2=l2.next;
        }
        //try a larger list with twice carryover
        return result;
    }





}

public class MainApplication {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1= new ListNode(4, l1);
        l1 = new ListNode(5, l1);

        ListNode l2 = new ListNode(7);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(5, l2);
        addTwoNumbers(l1, l2);
    }

    public static int i, j, sum, remainder;
    public static int oldCarry = 0;
    public static int curCarry;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        while(l1!=null && l2!=null) {
            i = l1.val;
            j = l2.val;
            sum = i+j;
            remainder = (sum+oldCarry)%10;
            curCarry = (sum+oldCarry) >=10 ? 1 : 0;
            if(curCarry>0){
                //account for multiple carryOver
                result= new ListNode(remainder, result);
                oldCarry=1;
            } else
                result= new ListNode(sum+oldCarry, result);
            System.out.println(l1.val + ": " + l2.val + ": " + result.val);

            //move up
            l1=l1.next;
            l2=l2.next;

            //carryOver on the last digit
            if( curCarry>0){
                    //account for additional digits
                    if(l1==null && l2!=null){
                        result= new ListNode(curCarry+l2.val, result);
                        System.out.println(result.val);
                    }
                    if(l2==null && l1!=null){
                        result= new ListNode(curCarry+l1.val, result);
                        System.out.println(result.val);
                    }
                    //two numbers have same digits
                    if(l1==null && l2==null){
                        result= new ListNode(curCarry, result);
                        System.out.println(result.val);
                    }
            }
        }
        return result;
    }





}

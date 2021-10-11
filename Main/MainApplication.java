import java.lang.String;
public class MainApplication {
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1= new ListNode(4, l1);
        l1 = new ListNode(5, l1);

        ListNode l2 = new ListNode(7);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(5, l2);
        addTwoNumbers(l1, l2);*/
        System.out.print(getCabFare(false, true, 20));
    }
    public static double getCabFare(boolean cabA, boolean dayTime, double distance){
        double fare;
        /*
        某市有甲乙两种出租车，其中，  甲型出租车收费标准如下： 起步价3公里(<=3)，白天（早6点到晚6点，下同）14元，晚上（晚6点到早6点，下同）18元
        3~10公里(>3且<=10)，白天每公里2.5元，晚上每公里3元
        10公里以上(>10)，白天每公里3.5元，晚上每公里4.7元；
         乙型出租车收费标准如下： 起步价3公里(<=3)，白天（早6点到晚6点，下同）14元，晚上（晚6点到早6点，下同）18元
        3公里以上(>3)，白天每公里2.5元，晚上每公里3元。
         */
        if(cabA){
            if(distance<=10){
                fare = getCabBFare(dayTime, distance);
            } else {
                fare = getCabBFare(dayTime, 10);
                fare += dayTime?3.5*(distance-10):4.7*(distance-10);
            }
        } else{
            fare = getCabBFare(dayTime,distance);
        }
        return fare;
    }
    public static double getCabBFare(boolean dayTime, double distance){
        double total, startFare;
        startFare = dayTime?14:18;
        if(distance<=3){
            total = startFare;
        } else {
            total = dayTime?2.5*(distance-3):3*(distance-3);
            total += startFare;
        }
        return total;
    }


    public static int returnIndex(int[] a, int expected){
        int index = -1;
        int j = 0;
        while(j<a.length){
            int sum = 0;
            for(int i = j; i<a.length; i++){
                sum += a[i];
                if(expected==sum){
                    index = i-j+1>index ? (i-j+1):index;
                }
            }
            ++j;

        }
        return index;
    }

    public static int i, j, sum, remainder;
    public static int oldCarry = 0;
    public static int curCarry;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        while (l1 != null && l2 != null) {
            i = l1.val;
            j = l2.val;
            sum = i + j;
            remainder = (sum + oldCarry) % 10;
            curCarry = (sum + oldCarry) >= 10 ? 1 : 0;
            if (curCarry > 0) {
                //account for multiple carryOver
                result = new ListNode(remainder, result);
                oldCarry = 1;
            } else
                result = new ListNode(sum + oldCarry, result);
            System.out.println(l1.val + ": " + l2.val + ": " + result.val);

            //move up
            l1 = l1.next;
            l2 = l2.next;

            //carryOver on the last digit
            if (curCarry > 0) {
                //account for additional digits
                if (l1 == null && l2 != null) {
                    result = new ListNode(curCarry + l2.val, result);
                    System.out.println(result.val);
                }
                if (l2 == null && l1 != null) {
                    result = new ListNode(curCarry + l1.val, result);
                    System.out.println(result.val);
                }
                //two numbers have same digits
                if (l1 == null && l2 == null) {
                    result = new ListNode(curCarry, result);
                    System.out.println(result.val);
                }
            }
        }
        return result;
    }





}

package practice.coding;

public class AddTwoNumber {

    public static void main(String[] args) {

        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3,null)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(2,null)));

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println();
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode result=new ListNode( 0,null);
        ListNode output=result;
        ListNode tail=result;
        int carry = 0;

        while(l1!=null || l2 != null){
            int sum = 0;

            if(l1!=null && l2!=null){
                sum = (int) (l1.val + l2.val + carry);
            } else if(l1!=null && l2==null){
                sum = (int) (l1.val + carry);
            } else if(l1==null && l2!=null){
                sum = (int) (l2.val + carry);
            }else {
               System.out.println("not valid");
            }

            System.out.print(sum+" ");
            int value = (int) (sum % 10);
            carry = (int) (sum / 10) ;
            ListNode newDifitNode = new ListNode( 0,null);
            result.next = newDifitNode;
            result.val = value;
            tail=result;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        if(carry>0) {
            tail.next.val = carry;
        }
        else{
            tail.next = null;
        }
        return output;
    }


    private ListNode fastest(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}


   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


import com.oracle.javafx.jmx.json.JSONWriter;

public class AddTwoNum {

    public static void main(String[] args) {
        ListNode a= new ListNode(2);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        a1.next = a2;
        a.next = a1;
        System.out.println("a:"+a.toString());
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        b.next = b1;
        System.out.println("b:"+b.toString());

        AddTwoNum addTwoNum = new AddTwoNum();
        ListNode listNode = addTwoNum.addTwoNumbers2(a, b);
        System.out.println(listNode.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(0);
        add(l1,l2,re);
        return  re;
    }
    /* 递归
    *  | n1  | n2  | n..  | N1
    *  | x1  | x2  | x..  | N2
    *
    *  | n1+x1=r1 %10  |RE ;r1>10 next.val+1
    *  | r1  | n2+x2+next.val=r2; |RE ;r2>10 next.val+1
    *  ......
    *  l1 != null || l2 !=null || last != 0 时继续
    * */
    public ListNode add(ListNode l1, ListNode l2,ListNode thisNode){
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        int lastVal = thisNode.val;
        int thisVal = l1.val + l2.val;
        thisNode.val = (lastVal + thisVal) % 10;
        int last = (lastVal + thisVal) >= 10 ?1:0;
        if(l1.next != null || l2.next != null || last > 0){
            ListNode te = new ListNode(last);
            thisNode.next = te;
            if(!(l1.next == null && l2.next == null && last == 0)){
                add(l1.next,l2.next,te);
            }
        }

        return  null;
    }

    /*
    * while
    * 同理
    * */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int last = 0;
        ListNode re = new ListNode(last);
        ListNode tmp = re;
        while(l1 != null || l2 !=null || last!=0 ){
            int l1v = l1 == null?0: l1.val;
            int l2v = l2 == null?0: l2.val;
            int nextVal = l1v + l2v + last;
            last = nextVal/10;
            tmp.next = new ListNode(nextVal % 10);
            tmp = tmp.next;
            l1 = l1 != null?l1.next:null;
            l2 = l2 != null?l2.next:null;
        }
        return  re.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

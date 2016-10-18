public class Test{
    public static void main(String [] args){
        
        Truck tr1 = new Truck(3, 10);
        Truck tr2 = new Truck(4, 14);
        Truck tr3 = new Truck(3, 7);
        Truck tr4 = new Truck(5, 30);

        Booth bt1 = new Booth();
        Booth bt2 = new Booth(10, 40);

        bt1.display(tr1);
        bt1.display(tr2);
        bt1.receiptCollection();
        bt1.display(tr3);
        bt1.display(tr4);
        bt1.totalReceiptCollection();

        bt2.display(tr1);
        bt2.display(tr2);
        bt2.display(tr3);
        bt2.display(tr4);
        bt2.totalReceiptCollection();
        bt2.receiptCollection();
    }
}

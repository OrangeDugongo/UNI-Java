public class Booth{

    public Booth(){
        this.dueAxles=5;
        this.dueTon=20;
        count=0;
        cash=0;
    }

    public Booth(int dueAxles, int dueTon){
        this.dueAxles=dueAxles;
        this.dueTon=dueTon;
        count=0;
        cash=0;
    }

    private int calcToll(Truck tr){
        return tr.getWeight()*dueTon + tr.getAxles()*dueAxles;
    }

    public void display(Truck tr){
        int money;
        System.out.println("Truck arrival - axles: "+tr.getAxles()+" total weight: "+tr.getWeight());
        money=calcToll(tr);
        System.out.println("Toll due: "+money);
        cash+=money;
        count++;
    }

    public void receiptCollection(){
        System.out.println("*******");
        System.out.println("Receipts: "+cash);
        System.out.println("Truck: "+count);
        System.out.println("*******");
    }

    public void totalReceiptCollection(){
        System.out.print("*******Total");
        receiptCollection();
        count=0;
        cash=0;
    }

    private int dueAxles;
    private int dueTon;
    private int count;
    private int cash;
}

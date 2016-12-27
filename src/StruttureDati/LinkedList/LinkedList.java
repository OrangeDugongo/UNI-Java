public class LinkedList{

    private class Node{
        public Object elem;
        public Node next;
    }

    public LinkedList(){
        head=null;
        len=0;
    }

    public Object elemAt(int pos){
        int i=0;
        Node temp=head;
        while(i<pos && temp!=null){
            temp=temp.next;
            i++;
        }
        if(temp=null || i!=pos)
            return null;
        else
            return temp.elem;
    }

    public void addAt(int pos, Object elem){
        int i=0;
        node temp=head;
        while(i<pos && temp!=null){
            temp=temp.next;
            i++;
        }
        if(i==pos && temp!=null){
            Node nuovo=new Node();
            nuovo.elem=elem;
            nuovo.next=temp.next;
            temp.next=nuovo;
            len++;
        }
    }

    public void remAt(int pos){
        int i=0;
        node temp=head;
        while(i<(pos-1) && temp!=null){
            temp=temp.next;
            i++;
        }
        if(i==(pos-1) && temp!=null && temp.next!=null){
            temp.next=temp.next.next;
            len--;
        }
    }

    private Node head;
    private int len;
}
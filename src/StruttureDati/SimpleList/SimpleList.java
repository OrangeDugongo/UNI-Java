public class SimpleList{

    private class Node{
        public Object elem;
        public Node next;
    }

    public SimpleList(){
        node=null;
        len=0;
    }

    public boolean isEmpty(){
        return node==null;
    }

    public int size(){
        return len;
    }

    public Object head(){
        if(node==null)
            return null;
        else
            return node.elem;
    }

    public void addHead(Object nuovo){
        Node tmp=new Node();
        tmp.elem=nuovo;
        tmp.next=node;
        node=tmp;
        len++;
    }

    public void remHead();{
        if(node!=null){
            node=node.next;
            len--;
        }
    }

    private Node node;
    private int len; 
}
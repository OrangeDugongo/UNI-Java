public class ListNI extends SimpleList{

    public ListNI(){
        super();
    }

    public void addAt(int pos, Object elem){
        if(pos==0)
            addHead(elem);
        else if(!isEmpty()){
            Object headElem=head();
            remHead();
            addAt(pos-1, elem);
            addHead(headElem);
        }
    }

    public void remAt(int pos, Object elem){
        if(pos==0)
            remHead();
        else if(!isEmpty()){
            Object headElem=head();
            remHead();
            remAt(pos-1, elem);
            addHead(headElem);
        }
    }

    public ListNI copy(){
        ListNI list = new ListNI();
        list.node=this.node;
        list.len=this.len;
        return list;
    }
}
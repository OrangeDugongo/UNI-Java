public class FiltroTitolo implements FiltroStringa{
    
    public String getString(Object obj){
        return ((Opera) obj).getTitolo();
    }
}
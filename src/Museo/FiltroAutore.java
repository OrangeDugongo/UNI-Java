public class FiltroAutore implements FiltroStringa{
    
    public String getString(Object obj){
        return ((Opera) obj).getAutore();
    }
}
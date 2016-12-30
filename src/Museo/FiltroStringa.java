public interface FiltroStringa{
    String getString(Object obj);
}

class FiltroSupporto implements FiltroStringa{

    public String getString(Object obj){
        if(obj instanceof OperaMult)
            return ((OperaMult) obj).getSupporto();
        else
            return "";
    }
}

class FiltroTecnica implements FiltroStringa{

    public String getString(Object obj){
        if(obj instanceof Stampa)
            return ((Stampa) obj).getTecnica();
        else
            return "";
    }
}

class FiltroAutore implements FiltroStringa{
    
    public String getString(Object obj){
        return ((Opera) obj).getAutore();
    }
}

class FiltroTitolo implements FiltroStringa{
    
    public String getString(Object obj){
        return ((Opera) obj).getTitolo();
    }
}

class FiltroPosizione implements FiltroStringa{

    public String getString(Object obj){
        return ((Opera) obj).getPos();
    }
}
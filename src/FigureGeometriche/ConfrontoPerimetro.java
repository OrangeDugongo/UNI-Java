public class ConfrontoPerimetro implements Confrontatore{

    public boolean confronto(Object ob1, Object ob2){
        FiguraGeometrica fg1 = (FiguraGeometrica) ob1;
        FiguraGeometrica fg2 = (FiguraGeometrica) ob2;

        return fg1.calcolaPerimetro()>fg2.calcolaPerimetro();
    }
}
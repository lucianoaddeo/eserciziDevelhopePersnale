public class ShapeFactory {

    public static Shape creaForma(Main.Forma f){
        return switch (f){
            case Cerchio -> new Cerchio();
            case Rettangolo -> new Rettangolo();
        };
    }
}

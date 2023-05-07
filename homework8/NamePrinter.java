package homework8;

public class NamePrinter {
    public void printName(Shape obj){
        Class figure = obj.getClass();
        System.out.println(figure.getName());
    }
}

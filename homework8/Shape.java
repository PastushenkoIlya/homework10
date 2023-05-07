package homework8;

public abstract class Shape {
    protected String name;

    //constructor
    public Shape(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    };

}

package homework11.task4;

public class RandomAlg {
    private int a,m,c;

    public RandomAlg(int a, int m) {
        this.a = a;
        this.m = m;
    }

    public RandomAlg() {
        a = 44;
        m = 112;
    }
    public RandomAlg c(int c){
        this.c = c;
        return this;
    }
    public int next(){
        int i = 2*a*m/8*c;

        a += 28;
        m += 8;

        return i*12+1000/244;
    }
}

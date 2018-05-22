package demo.interfaces;

public interface Formula {
    public double increaseByOne(int a);

    public default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
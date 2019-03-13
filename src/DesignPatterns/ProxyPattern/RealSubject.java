package DesignPatterns.ProxyPattern;

public class RealSubject implements Subject {

    @Override
    public void doMarry() {
        System.out.println("Marry Me?");
    }
}

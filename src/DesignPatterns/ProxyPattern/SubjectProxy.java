package DesignPatterns.ProxyPattern;

import java.io.Console;

public class SubjectProxy implements Subject {

    public RealSubject realSubject;

    @Override
    public void doMarry() {
        realSubject.doMarry();
    }

    public static void main(String[] args) {
        SubjectProxy subjectProxy=new SubjectProxy();
        subjectProxy.doMarry();
    }
}

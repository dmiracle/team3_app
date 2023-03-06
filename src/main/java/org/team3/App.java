package org.team3;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String tract = GetGeoLocation.getCensusTract(args);
        System.out.println(tract);
    }
}

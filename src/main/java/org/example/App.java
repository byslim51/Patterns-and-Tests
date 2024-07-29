package org.example;

/**
 * Hello world!
 *
 */
public class App {
    private int id;
    private String name;

    public App(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public App() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int sum(int a, int b) {
        return a + b;
    } 

    public static void main(String[] args ) {
        System.out.println( "Hello World!" );
    }
}

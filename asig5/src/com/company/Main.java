package com.company;

public class Main {

    public static void main(String[] args) {
        InterfaceDB db = new Database();
        InterfaceProjectRes repo = new ProjectRes(db);
        Controller controller = new Controller(repo);
        App app = new App(controller);
        app.start();
    }
}

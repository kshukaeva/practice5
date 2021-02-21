package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {

        private final Controller controller;
        private final Scanner scanner;

        public App(Controller controller) {
            this.controller = controller;
            scanner = new Scanner(System.in);
        }

        public void start() {
            while (true) {
                System.out.println();
                System.out.println("Welcome to My Application");
                System.out.println("Select option:");
                System.out.println("1. Get all projects");
                System.out.println("2. Get projects by id");
                System.out.println("3. Create project");
                System.out.println("0. Exit");
                System.out.println();
                try {
                    System.out.print("Enter option (1-3): ");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        getAllProjectsMenu();
                    } else if (option == 2) {
                        getAllProjectsByIdMenu();
                    } else if (option == 3) {
                        createProjectMenu();
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("*************************");

            }
        }

        public void getAllProjectsMenu() {
            String response = controller.getAllProjects();
            System.out.println(response);
        }

        public void getAllProjectsByIdMenu() {
            System.out.println("Please enter id");

            int id = scanner.nextInt();
            String response = controller.getProject(id);
            System.out.println(response);
        }

        public void createProjectMenu() {
            System.out.println("Please enter name");
            String name = scanner.next();
            System.out.println("Please enter totalCost");
            int totalCost = Integer.parseInt(scanner.next());


            String response = controller.createProject(name,totalCost);
            System.out.println(response);
        }
    }

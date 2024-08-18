package task;

import contact.Contact;

import java.util.Scanner;

public class TaskManager {


    public  void start(){
        boolean b=true;
        while (b){
            menu();

            int n= getMenuNumber();

            switch (n){
                case 1 :

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :
                    break;
                case 5:
                    break;
                case 0 :
                    b=false;
                    break;
                default:
                    System.out.println("choose correct number");
            }
        }


    }
    public  void menu(){
        System.out.println("** Menu **");
        System.out.println("1. Add Task");
        System.out.println("2. Task List");
        System.out.println("3. ChangeStatus By Name");
        System.out.println("4. ChangeStatus By Id");
        System.out.println("5. Active Task List");
        System.out.println("0. Exit");


    }
    public   int getMenuNumber(){
        System.out.print("Choose Menu: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();

    }
}

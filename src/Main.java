import contact.ContactManager;

import task.TaskManager;



    public class Main {
    public static void main(String[] args) {
        ContactManager contactManager=new ContactManager();
        TaskManager taskManager = new TaskManager();
        boolean b=true;
        while (b){
            menu();

            int n= helper.Menu.getMenuNumber();

            switch (n){
                case 1 :

                    contactManager.start();
                    break;
                case 2 :

                    taskManager.start();
                    break;

                case 0 :
                    b=false;
                    break;
                default:
                    System.out.println("choose correct number");
            }
        }

    }

        public static void menu(){
            System.out.println("** Menu **");
            System.out.println("1. Contact Manager");
            System.out.println("2. Task Manager");

            System.out.println("0. Exit");


        }


}
package task;

import contact.Contact;

import java.util.Scanner;

public class TaskManager {
  public Task[] taskArray= new Task[10];
  public  int currentIndex=0;


    public  void start(){
        boolean b=true;
        while (b){
            menu();

            int n= getMenuNumber();

            switch (n){
                case 1 :
                    Task task=addTask();
                    addToArray(task);
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
  public void addToArray(Task task){
        if (taskArray.length==currentIndex){
            Task[] newArray=new Task[taskArray.length*2];
            for (int i=0;i<taskArray.length;i++){
                newArray[i]=taskArray[i];
            }
            taskArray=newArray;
        }
        taskArray[currentIndex]=task;
        currentIndex++;

  }
    public  Task addTask(){
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter Title: ");
        String title=scanner.next();

        System.out.print("Enter content: ");
        String content=scanner.next();

        Task task=new Task();
        task.setContent(content);
        task.setTitle(title);


        return  task;

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

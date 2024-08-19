package task;

import contact.Contact;

import java.util.Scanner;

public class TaskManager {
  public Task[] taskArray= new Task[10];
  public  int currentIndex=0;
  public  int generalId=1;


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
                   printAllTask();
                    break;
                case 3 :
                    String title=getTaskTitle();
                   changeStatusByTitle(title);
                    break;
                case 4 :
                    int id =getTaskId();
                    changeStatusById(id);
                    break;
                case 5:
                    printActiveTasks();
                    break;
                case 0 :
                    b=false;
                    break;
                default:
                    System.out.println("choose correct number");
            }
        }


    }
    public  int getTaskId(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Insert Id: ");
        int id=scanner.nextInt();
        return  id;
    }
    public void changeStatusById(int id){

        boolean errorStatus=true;
        for (Task t:taskArray){
            if (t!=null && t.getId()==id){
                errorStatus=false;
                if (t.getStatus().equals("ACTIVE")){
                    t.setStatus("DONE");
                }else {
                    t.setStatus("ACTIVE");
                }
            }
        }
        if (errorStatus){
            System.out.println("id not found");
        }
    }
    public void printAllTask(){
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("|                          Task List                                         |%n");
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-40s | %-6s |%n", "Id", "Title", "Content", "Status");

        for (Task task:taskArray){
            if (task!=null){

                System.out.printf("| %-3s | %-15s | %-40s | %-6s |%n",
                        task.getId() ,task.getTitle(),task.getContent(),task.getStatus());
            }
        }
        System.out.printf("------------------------------------------------------------------------------%n");
    }
    public void printActiveTasks(){
        boolean errorStatus=true;
        for (Task task:taskArray){
            if (task!=null&& task.getStatus().equals("ACTIVE")){
               errorStatus=false;
                System.out.println(task.getId()+" "
                        +task.getTitle()+" "
                        +task.getContent()+" "
                        +task.getStatus());
            }
        }
        if (errorStatus){
            System.out.println("active tasks not found");
        }
    }
    public  String getTaskTitle(){
    Scanner scanner=new Scanner(System.in);
    System.out.print("Inserting Title: ");
    String title=scanner.next();
    return title;
}
    public void changeStatusByTitle(String title){

        boolean errorStatus=true;
        for (Task t:taskArray){
            if (t!=null && t.getTitle().equals(title)){
                errorStatus=false;
                if (t.getStatus().equals("ACTIVE")){
                    t.setStatus("DONE");
                }else {
                    t.setStatus("ACTIVE");
                }
            }
        }
        if (errorStatus){
          System.out.println("title not found");
        }
    }
  public void addToArray(Task task){
      task.setStatus("ACTIVE");
      task.setId(generalId++);

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
        String title=scanner.nextLine();

        System.out.print("Enter content: ");
        String content=scanner.nextLine();

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

package helper;

import java.util.Scanner;

public class Menu {

    public  static int getMenuNumber(){
        System.out.print("Choose Menu: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();

    }
}

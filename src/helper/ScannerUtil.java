package helper;

import java.util.Scanner;

public class ScannerUtil {

    public  static Scanner scanner;
    static {
        scanner=new Scanner(System.in);
    }
    public  static int getMenuNumber(){
        System.out.print("Choose Menu: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();

    }

}

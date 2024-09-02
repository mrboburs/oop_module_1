package sms;

import contact.Contact;
import contact.ContactManager;
import helper.ScannerUtil;
import task.Task;
import java.time.LocalDateTime;
import static helper.ScannerUtil.scanner;
import static helper.ScannerUtil.scannerLine;

public class SmsManager {
    public Sms[] smsArray= new Sms[10];
    public  Integer currentIndex=0;
    public  Integer generalId=1;
    private ContactManager contactManager;

    public SmsManager(ContactManager contactManager) {
        this.contactManager = contactManager;
    }
    public  void start(){
        Boolean b=true;
        while (b){
            menu();

            Integer n= ScannerUtil.getMenuNumber();

            switch (n){
                case 1 :
                    Sms sms=getSms();
                    addToArray(sms);
                    break;
                case 2 :
                   String phone=getInputPhone();
                   smsHistory(phone);
                    break;
                case 3 :
                    allSmsHistory();
                    break;
                case 4 :
                   String phoneNumber=deletePhoneInput();
                   deleteSmsFromArray(phoneNumber);
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
    public  String deletePhoneInput(){
        System.out.print("Enter phone input: ");

        return  scannerLine.nextLine();
    }
    public void deleteSmsFromArray(String phone){
        for (Integer i=0;i<smsArray.length;i++){
            if (smsArray[i]!=null && smsArray[i].getPhone().equals(phone)){
                smsArray[i]=null;
                System.out.println("sms deleted!!!");
                break;
            }
        }
    }
    public   String getInputPhone(){
        System.out.print("Enter phone: ");

        return  scannerLine.nextLine();

    }
    public void allSmsHistory(){
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("|                          Sms List                                         |%n");
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-40s |%n", "Id", "Phone", "Text");

        for (Sms sms:smsArray){
            if (sms!=null ){
                System.out.printf("| %-3s | %-15s | %-40s |%n",
                        sms.getId(),sms.getPhone(),sms.getText()
                );
            }
        }
        System.out.printf("------------------------------------------------------------------------------%n");
    }
    public void smsHistory(String phone){
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("|                          Sms List                                         |%n");
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-40s |%n", "Id", "Phone", "Text");

        for (Sms sms:smsArray){
            if (sms!=null && sms.getPhone().equals(phone)){
                System.out.printf("| %-3s | %-15s | %-40s |%n",
                        sms.getId(),sms.getPhone(),sms.getText()
                );
            }
        }
        System.out.printf("------------------------------------------------------------------------------%n");
    }
    public  void addToArray(Sms sms){
        sms.getPhone();
        boolean b=contactManager.isPhoneExist(sms.getPhone());
        if (!b){
            System.out.println("Phone not found");
            return;
        }
      sms.setId(generalId++);
      sms.setCreatedDate(LocalDateTime.now());

        if (currentIndex==smsArray.length){
            Sms[]newArray= new Sms [smsArray.length*2];
            for (int i=0;i<smsArray.length;i++){
                newArray[i]=smsArray[i];
            }
            smsArray=newArray;
        }
        smsArray[currentIndex]=sms;
        currentIndex++;
        System.out.println("sms added");

    }
    public  void menu(){
        System.out.println("** Sms Manager Menu **");
        System.out.println("1. Send Sms");
        System.out.println("2. Sms History");
        System.out.println("3. All Sms History");
        System.out.println("4. Delete Sms History");
        System.out.println("0. Exit");


    }
    public Sms getSms(){
        System.out.print("Enter phone: ");
        String phone=scannerLine.nextLine();

        System.out.print("Enter text: ");
        String text=scannerLine.nextLine();

        Sms sms=new Sms();
        sms.setPhone(phone);
        sms.setText(text);

        return  sms;

    }
}

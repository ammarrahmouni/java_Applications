package firstproject;

import java.util.*;
import java.text.*;
import java.util.InputMismatchException;

public class Login{
    public static void main(String[] args){
        Login user = new Login();
        user.input();
        user.loginSystem();
    }

    private String username;
    private String password;
    private int yearBrith;
    private int mountBrith;
    private int dayBrith;
    private int ageYear;
    private int ageMounth;
    private int ageDay;
    private int ageHour;
    private int ageMinute;
    private int operate;
    private String text;
    private char alpha; 
    private int toplam;
    private String operate2; 
    private int cheekA;
    private int cheekB;
    
    Scanner read = new Scanner(System.in);
    Date date = new Date();
    SimpleDateFormat nowDate = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat nowTime = new SimpleDateFormat("hh:mm:ss a");
    SimpleDateFormat sy = new SimpleDateFormat("yyyy");
    SimpleDateFormat sm = new SimpleDateFormat("MM");
    SimpleDateFormat sd = new SimpleDateFormat("dd");
    SimpleDateFormat sh = new SimpleDateFormat("hh");
    SimpleDateFormat st = new SimpleDateFormat("mm");

    public Login(){ //Constructor method
        System.out.println("Today Date is : " + nowDate.format(date));
        sleep(100);
        System.out.println("Now Time is : " + nowTime.format(date));
        sleep(100);
        System.out.println("---------------------------");
        sleep(100);
        System.out.println("Welcome in the program");
        sleep(100);
        System.out.println("---------------------------");
        sleep(500);
        username = "None";
        password = "None"; 
        yearBrith = 0;
        ageYear = 0;
        operate = 0;
        text = "None";
        alpha = ' ';
        toplam = 0;
        cheekA = 0;
        cheekB = 0;
    }//Constructor method

    /* getter methodu for username varaible */
    public String getUser(){ //getUser method
        return username;
    }//getUser method

    /* getter methodu for password varaible */
    public String getPas(){ //getPas method
        return password;
    }//getPas method

    /* getter methodu for ageYear varaible */
    public int getAge(){  //getAge method
        return ageYear;
        
    } //getAge method

    /* This method allows the user to enter his data */
    public void input(){ //input method
        System.out.println("Please Enter Your username: ");
        username = read.nextLine();
        System.out.println("Please Enter Your passwords: ");
        password = read.nextLine();
        if(assertFromInfo()){
            sleep(500);
            System.out.println("username and password is correct.");
            sleep(300);
            System.out.println("Signing in...");
            sleep(500);
        }
        else{
            System.out.println("username or passwords it is not correct.");
            System.out.println("Plesae make sure your username and passwords and try again.");
            input();
        }
    }//input method

    /* This method shows user data */
    public void output(){ //output method
        if(assertFromInfo()){
            sleep(300);
            System.out.println("User Info:");
            sleep(300);
            System.out.println("username is: " + username);
            sleep(300);
            System.out.println("password is: " + password);
        }
    }//output method

    /* The method check up user data */
    public Boolean assertFromInfo(){ //assertFromInfo method
        //Burda Dikkat String olan username değişkeni equals fonk çağırırken yaptık (==) ile olamaz.
        //Bu sadece String tibi değişkenler de olur.
        if(username.equals("ammar") && password.equals("05366394454"))
            return true;
        else
            return false;
    }//assertFromInfo method

    /* This method allows the user to access his account */
    public void loginSystem(){ //loginSystem method
        try{//Try block
            
            if(cheekB == 1){//if block
                read.next();
                cheekB = 0;
            }//if block

            if(assertFromInfo()){//if block
                sleep(100);
                System.out.println("--------------Welcome in your account------------");
                sleep(100);
                System.out.println("Please specify the number for the operation you wish to perform: ");
                sleep(100);
                System.out.println("1- Apply Age Account");
                sleep(100);
                System.out.println("2- Applying the calculation of imported text characters");
                sleep(100);
                System.out.println("3- To show your account information");
                sleep(100);
                System.out.println("4- Sign out of account and exit the program");
                sleep(100);
                System.out.println("5- Exit form program");
                operate = read.nextInt();
                sleep(500);
                if(operate == 1){
                    ageAccount(); //Burda Dikkat ageAccount methodu try Block'un içinde olduğu için artık o metodu içinde eğer bir exception olursa burdaki catch kısımına düzenlenir, yani ageAccount metodunda try ve catch blokları yazmayı gerek yoktur eğer ordaki hatayi aynı şekilde düzenleyacaksek.
                }
                else if(operate == 2){
                    charactersAccount();
                }
                else if(operate == 3){
                    output();
                    mainMenu();
                }
                else if(operate == 4){
                    logoutFromAccount();
                }
                else if(operate == 5){
                    exitFromProgram();
                }
                else{
                    System.out.println("Please make sure you enter correct information and try again.");  
                    loginSystem();
                }
            }//if block
            else {
                System.out.println("Please make sure your username and password are correct and try again later.");
                input();
                loginSystem();
            }
        }//Try block
        catch (InputMismatchException e) {
            cheekB = 1;
            System.out.println("Please make sure you enter correct information and try again later.");
            loginSystem();
        }

    }//loginSystem method

    /* This method calculates the user's age*/
    public void ageAccount() { //ageAccount method 
        
        try{
            if(cheekA == 1){
                read.next();
                cheekA = 0;
            }
            System.out.println("Please Enter Your Brith Year:");
            yearBrith = read.nextInt();
            System.out.println("Please Enter Your Brith Mounth:");
            mountBrith = read.nextInt();
            System.out.println("Please Enter Your Brith Day:");
            dayBrith = read.nextInt();
            ageYear = Integer.valueOf(sy.format(date)) - yearBrith;
            ageMounth = Integer.valueOf(sm.format(date)) - mountBrith;
            ageDay = Integer.valueOf(sd.format(date)) - dayBrith; 
        }
        catch(InputMismatchException r){
            cheekA = 1;
            System.out.println("Please make sure you enter correct information and try again later.");
            ageAccount();
        }

        if(yearBrith > Integer.valueOf(sy.format(date)) || mountBrith > 12 || dayBrith > 31){
            System.out.println("Erorr! Make sure that the number of the month you entered is not greater than 12 and that the day number you entered is not greater than 31 and that the year number you entered is not greater than current year and try again.");
            ageAccount();
        }
        else if(yearBrith >= Integer.valueOf(sy.format(date)) && mountBrith > Integer.valueOf(sm.format(date))){
            System.out.println("Erorr! Your date of birth can not be greater than the current date");
            System.out.println("Please try agin, and make sure your brith date Younger than the current date");
            ageAccount();
        }
        else if(yearBrith >= Integer.valueOf(sy.format(date)) && mountBrith >= Integer.valueOf(sm.format(date)) && dayBrith > Integer.valueOf(sd.format(date))){
            System.out.println("Erorr! Your date of birth can not be greater than the current date");
            System.out.println("Please try agin, and make sure your brith date Younger than the current date");
            ageAccount();
        }
        else{
            if(ageDay < 0 && ageMounth < 0){
                ageMounth -= 1;
                ageMounth += 12;
                switchMounthBrith();
                ageYear -= 1;
            }
            else if(ageDay == 0 && ageMounth < 0){
                ageYear -= 1;
                ageMounth += 12;
            }
            else if(ageDay < 0 && ageMounth > 0){
                switchMounthBrith();
                ageMounth -= 1;
            }
            else if(ageDay < 0 && ageMounth == 0){
                ageMounth -= 1;
                ageMounth += 12;
                switchMounthBrith();
                ageYear -= 1;
            }
            else if(ageDay > 0 && ageMounth < 0){
                ageMounth += 12;
                ageYear -= 1;
            }
            else if(ageDay == 0 && ageMounth == 0){
                System.out.println("Today is your Brith day!");
            }
        }
        sleep(1000);
        System.out.println("Your age by year is : " + ageYear + " Year and " + ageMounth + " mounth and " + ageDay + " day");
        sleep(100);
        System.out.println("Your age by mounth is : " + ageByMounth());
        sleep(100);
        System.out.println("Your age by day is : " + ageByDay());
        sleep(100);
        System.out.println("Your age by hours is : " + ageByHour());
        sleep(100);
        System.out.println("Your age by minute is : " + ageByMinute());
        sleep(100);
        System.out.println("Stay for your birthday : " + brithDay() + " Day");
        mainMenu();
    }//ageAccount method

    /* This method sort day from mounth */
    public void switchMounthBrith(){ //switchMounthBrith
        switch (mountBrith) {
            case 1: 
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                ageDay += 31;
                break;

            case 4: 
            case 6:
            case 9:
            case 11:
                ageDay += 30;
                break;
            case 2: 
                ageDay += 28;
                break;
            default: 
                break;
        }
    }//switchMounthBrith

    /* This methodu calculates the user's age by mounth */
    public int ageByMounth(){ //ageByMounth method
        return (ageYear * 12 + ageMounth);
    }//ageByMounth method

    /* This methodu calculates the user's age by day */
    public int ageByDay(){ //ageByDay method
        return (ageYear * 365 + ageMounth * 30 + ageDay);
    }//ageByDay method

    /* This methodu calculates the user's age by hours */
    public int ageByHour(){//ageByHour method
        ageHour = Integer.valueOf(sh.format(date));
        return (ageByDay() * 24 + ageHour);
    }//ageByHour method

    /* This method calculates the user's age bu minute */
    public int ageByMinute(){//ageByMinute method
        ageMinute = Integer.valueOf(st.format(date));
        return (ageByHour() * 60 + ageMinute);
    }//ageByMinute method

    /* This method calculates how many day stay for user's brith day*/
    public int brithDay(){ //brithDay method
        ageMounth = 11 - ageMounth;
        ageDay = 30 - ageDay;
        return (ageMounth * 30 + ageDay + 5);
    }//brithDay method

    /* This method calculates the number of characters entered */
    public void charactersAccount(){ //charactersAccount method
        int num = 1;
        // public,protected,private int a = 4; Hata metodun içinde değişkenler tipi defualt olmalıdır.
        String operate2;   
        System.out.println("Please enter the text:");
        read.nextLine(); //Bu bir stıra inmesi için kullanıyoruz.
        text = read.nextLine();
        for(int i = 0; i < text.length(); i++){
            alpha = text.charAt(i);
            if(alpha != ' ' && alpha != ',' && alpha != ':' && alpha != '.' && alpha != '!' && alpha != '/' && alpha != '?'
            && alpha != '-' && alpha != '_' && alpha != '(' && alpha != ')' && alpha != '{' && alpha != '}' && alpha != '^'
            && alpha != '#' && alpha != ';' && alpha != '+' && alpha != '*' && alpha != '%' && alpha != '=' && alpha != '&'
            && alpha != '|' && alpha != '<' && alpha != '>' && alpha != '$' && alpha != '~')
            
            {
                sleep(50);
                System.out.println(num + "." + alpha);
                num++;
            }
        }
        toplam = num - 1;
        sleep(500);
        System.out.println("The total number of text characters is: " + toplam + " characters.");
        mainMenu();
    } //charactersAccount method

    /* This method allows the user to return to the main menu or shutdown the program */
    public void mainMenu(){ //mainMenu method
        sleep(1000);
        System.out.println("If you want to go back to the main menu please press the return button and if you want to exit press the exit button:");
        operate2 = read.next();
        if(operate2.equals("return") || operate2.equals("Return") || operate2.equals("RETURN")){
            sleep(500);
            loginSystem();
        }
        else if(operate2.equals("exit") || operate2.equals("Exit") || operate2.equals("EXIT")){
            exitFromProgram();
        }
        else{
            System.out.println("Please make sure you enter correct information and try again later.");  
            mainMenu();
        }

    }//mainMenu method

    /* This method is logout from account user's */
    public void logoutFromAccount(){//logoutFromAccount method
        System.out.println("Signing out of account...");
        sleep(1500);
        System.out.println("Logged out.");
        exitFromProgram();
    }//logoutFromAccount method

    /* This method closes the program */
    public void exitFromProgram(){ //eixtFromProgram method
        sleep(1000);
        System.out.println("Thank You Mr." + username + "!");
        sleep(500);
        System.exit(-1);
    }//eixtFromProgram method

    /*This method make program is watie */
    public void sleep(int time){//sleep method
        try{
            Thread.sleep(time);
        }
        catch(Exception e){

        }
    }//sleep method

}//class Login
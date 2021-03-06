package sortalgorithm;

import java.util.*;
import java.util.InputMismatchException;

public class BubbleSort implements interfaceSortArray{
    public static void main(String[] args) {
        BubbleSort dizi = new BubbleSort();
        dizi.input();
        dizi.sortArray(); 
        System.out.println("--------------------------");
        dizi.printArray();
    }

    Scanner read = new Scanner(System.in);
    int[] array ;
    private int arraySize;
    private int key;
    private int cheek;

    public BubbleSort(){
        cheek = 0;
        sleep(400);
        System.out.println("Welcome in The program");
        sleep(400);
        System.out.println("--------------------------");
        sleep(400);
        System.out.println("This program arranges the input elements by Bubble sort algorithm.");
        sleep(400);
        System.out.println("--------------------------");
        sleep(700);
    }

    public void input(){
        try{
            if(cheek == 1){
                read.next();
                cheek = 0;
            }
            System.out.println("Please enter the number of digits you want to store:");
            arraySize = read.nextInt();
            array = new int[arraySize];
            System.out.println("Please enter the set of numbers you want to order:");
            for(int i = 0; i < arraySize; i++)
            {
                System.out.print((i + 1) + ".Number: ");
                array[i] = read.nextInt();
            }
        }
        catch(InputMismatchException e){
            cheek = 1;
            System.out.println("Please do not enter letters or symbols, Please enter only Integer numbers.");
            input();
        }

    }

    public int[] sortArray(){
        int temp;
        for(int j = 0; j < arraySize; j++){
            for(int i = 0; i < arraySize - j - 1; i++){
                if(array[i] > array[i + 1]){
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public void printArray(){
        System.out.println("Order Array :");
        sleep(500);
        for(int i = 0; i < arraySize; i++){
            sleep(300);
            System.out.println((i + 1) + ".Number : " + array[i]);
        }
    }

    public void sleep(int time){
        try{
            Thread.sleep(time);
        }
        catch(Exception e){

        }
    }
}
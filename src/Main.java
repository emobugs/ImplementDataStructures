import interfaces.List;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Java List
        java.util.List<String> list = new ArrayList<>();

        list.add("hamala");
        list.add("baiShile");
        list.add("Kolio");


        System.out.println(list.isEmpty());


//        My List

        List myList = new list.ArrayList();
        myList.add("Pesho");
        myList.add("Mitko");
//        myList.add("Hamal");
//        myList.add("Kaloan");
//        myList.add("Vunio");
//        myList.add("Sheker");
//        myList.add("Manco");
//        myList.add("Alfonso");
//        myList.add("Tiger");
//        myList.add("Sasho");


        System.out.println("Before remove: (must be not empty) " + myList.isEmpty());

//        To add: implement clone method without using Arrays class
        java.util.List<String> copy = myList.clone();


        myList.remove(0);
        myList.remove(0);

        System.out.println(myList.contains("Vunio"));
        System.out.println(myList.contains("Vun"));

        System.out.println(myList.size());

        System.out.println("After remove: (must be empty) " + myList.isEmpty());


        System.out.println();


        System.out.println();

    }
}

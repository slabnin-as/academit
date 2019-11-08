package main;

import list.*;

public class Main {
    public static void main(String[] args) {
        String[] test = {"AcademIT", "433", "test", null, "NSK", "3467"};
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        for (String e : test) {
            list.addFirstElement(e);
        }
        System.out.println(list);

        list.deleteElement(0);
        System.out.println(list);
        list.insertElement(3,"TestElem");
        System.out.println(list);
    }
}

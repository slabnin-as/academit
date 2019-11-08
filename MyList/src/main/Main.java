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
        //получение размера списка
        System.out.println(list.getSize());
        //получение значения первого элемента
        System.out.println(list.getFirstElementValue());
        //получение значения по индексу
        System.out.println(list.getValue(3));
        //изменение значения по индексу
        list.setValue(3, "ChangedValue");
        System.out.println(list + ":" + list.getSize());
        //удаление элемента по индексу
        list.deleteElement(4);
        System.out.println(list + ":" + list.getSize());
        //вставка элемента в начало
        list.addFirstElement("First");
        System.out.println(list + ":" + list.getSize());
        //вставка элемента по индексу
        list.insertElement(5, "Spring");
        System.out.println(list + ":" + list.getSize());
        //удаление по значению
        list.deleteByValue("NSK");
        System.out.println(list + ":" + list.getSize());
        //удаление первого элемента
        list.deleteFirstElement();
        System.out.println(list + ":" + list.getSize());
        //разворот списка
        list.reverse();
        System.out.println(list + ":" + list.getSize());
    }
}

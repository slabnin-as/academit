package listmain;

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
        System.out.println(list.getHead());
        //получение значения по индексу
        System.out.println("Get element by INDEX");
        System.out.println(list.getValue(5));
        //изменение значения по индексу
        System.out.println(list.setValue(3, "ChangedValue"));
        System.out.println(list + ":" + list.getSize());
        //удаление элемента по индексу
        System.out.println("Delete by Index");
        System.out.println(list.deleteElement(5));
        System.out.println(list + ":" + list.getSize());
        //вставка элемента в начало
        list.addFirstElement("First");
        System.out.println(list + ":" + list.getSize());
        //вставка элемента по индексу
        list.insertElement(6, "Spring");
        System.out.println(list + ":" + list.getSize());
        //удаление по значению
        System.out.println("DeleteByValue");
        System.out.println(list.deleteByValue("433"));
        System.out.println(list + ":" + list.getSize());
        //удаление первого элемента
        list.deleteFirstElement();
        System.out.println(list + ":" + list.getSize());
        //разворот списка
        list.reverse();
        System.out.println(list + ":" + list.getSize());
        //копирование списка
        SinglyLinkedList<String> list2 = list.copy();
        System.out.println(list2);
    }
}

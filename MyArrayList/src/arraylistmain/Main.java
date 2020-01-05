package arraylistmain;

import arraylist.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(0);
        list1.add(12);
        list1.add(34);
        list1.add(54);
        list1.add(-8);
        MyArrayList<Integer> list2 = new MyArrayList<>(8);
        list2.add(101);
        list2.add(102);
        list2.add(103);
        System.out.println(list1);
        System.out.println(list2);

        list2.add(1, -258);
        System.out.println(list2);

        list1.addAll(list2);
        System.out.println(list1);

        list1.addAll(3, list2);
        System.out.println(list1);

        list1.remove(0);
        list1.trimToSize();
        System.out.println(list1);

        System.out.println(list2);
        list1.removeAll(list2);
        System.out.println(list1);

        MyArrayList<String> list3 = new MyArrayList<>(0);
        list3.ensureCapacity(10);
    }
}

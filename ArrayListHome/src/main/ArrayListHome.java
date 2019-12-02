package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();

        //считывание файла и добавление в список построчно
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }
        //удаление четных чисел из списка
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19));

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 == 0) {
                numList.remove(i);
                i--;
            }
        }
        System.out.println(numList);
        System.out.println();

        //чистка списка от дубликатов
        ArrayList<Integer> numList2 = new ArrayList<>(Arrays.asList(11, 11, 15, 12, 13, 11, 15, 16, 17, 12, 15));
        ArrayList<Integer> numListNoDuplicates = new ArrayList<>();

        for (Integer e : numList2) {
            if (!numListNoDuplicates.contains(e)) {
                numListNoDuplicates.add(e);
            }
        }
        System.out.println(numList2);
        System.out.println(numListNoDuplicates);
    }
}

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        ArrayList<String> linesFromFileList = new ArrayList<>();

        //считывание файла и добавление в список построчно
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            while (scanner.hasNextLine()) {
                linesFromFileList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        }

        for (String str : linesFromFileList) {
            System.out.println(str);
        }
        System.out.println();

        //удаление четных чисел из списка
        ArrayList<Integer> numbersList1 = new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19));

        for (int i = 0; i < numbersList1.size(); i++) {
            if (numbersList1.get(i) % 2 == 0) {
                numbersList1.remove(i);
                i--;
            }
        }
        System.out.println(numbersList1);
        System.out.println();

        //чистка списка от дубликатов
        ArrayList<Integer> numbersList2 = new ArrayList<>(Arrays.asList(11, 11, 15, 12, 13, 11, 15, 16, 17, 12, 15));
        ArrayList<Integer> listWithoutDuplicateNumbers = new ArrayList<>();

        for (Integer e : numbersList2) {
            if (!listWithoutDuplicateNumbers.contains(e)) {
                listWithoutDuplicateNumbers.add(e);
            }
        }
        System.out.println(numbersList2);
        System.out.println(listWithoutDuplicateNumbers);
    }
}

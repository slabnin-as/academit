package csvparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadCsv {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("input.csv")); PrintWriter writer = new PrintWriter("index.html")) {
            while (scanner.hasNextLine()) {
                final char quotes = '\"';
                final char separator = ',';
                String cellStr = null;
                int separatorIndex;
                int doubleQuoteIndex;

                String line = scanner.nextLine();
                if (line.charAt(0) != quotes) {
                    separatorIndex = line.indexOf(separator);
                    if (separatorIndex > 0) {
                        cellStr = line.substring(0, separatorIndex);
                    } else {
                        cellStr = line;
                    }
                }
                if (line.charAt(0) == quotes) {
                    doubleQuoteIndex = line.indexOf("\"\"");
                    if (doubleQuoteIndex > 0) {
                        separatorIndex = line.indexOf("\",", doubleQuoteIndex+2);
                    } else {
                        separatorIndex = line.indexOf("\",");
                    }
                    if (separatorIndex > 0) {
                        cellStr = line.substring(1, separatorIndex);
                    } else {
                        cellStr = line;
                    }
                }
                System.out.println(cellStr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        }
    }
}

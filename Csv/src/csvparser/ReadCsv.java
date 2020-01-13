package csvparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsv {
    private static String quotes = "\"";

    public static void main(String[] args) {
        String cellsLineSeparator = "<br/>";

        try (Scanner scanner = new Scanner(new FileInputStream("input.csv")); PrintWriter writer = new PrintWriter("index.html")) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<title>Парсер CSV</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\">");

            while (scanner.hasNextLine()) {
                StringBuilder line = new StringBuilder(scanner.nextLine());
                String[] splitText = line.toString().split(",");
                ArrayList<String> cells = new ArrayList<>();

                for (int i = 0; i < splitText.length; i++) {
                    if (readNextLine(splitText[i])) {
                        line.append(cellsLineSeparator).append(scanner.nextLine());
                        splitText = line.toString().split(",");
                    }
                    if (isPrevCellsPart(splitText[i])) {
                        cells.set(cells.size() - 1, cells.get(cells.size() - 1) + "," + splitText[i]);
                    } else {
                        cells.add(splitText[i]);
                    }
                }

                writer.println("<tr>");
                for (String cell : cells) {
                    if (cell.charAt(0) == '\"') {
                        cell = clearQuotes(cell);
                    }
                    cell = cell.replaceAll("\"\"", quotes);
                    writer.println("<td>");
                    writer.println(cell);
                    writer.println("</td>");
                }
                writer.println("</tr>");
            }

            //конец HTML файла
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        }
    }

    //проверка что следующий кусок после разделения является частью предыдущего
    private static boolean isPrevCellsPart(String text) {
        return text.indexOf(quotes) == text.lastIndexOf(quotes) && text.endsWith(quotes);
    }

    //проверка на перенос строки внутри ячейки
    private static boolean readNextLine(String text) {
        return text.startsWith(quotes) && !text.endsWith(quotes);
    }

    //удаление кавычек ограничителей строки
    private static String clearQuotes(String text) {
        return text.substring(1, text.length() - 1);
    }
}

import java.util.Scanner;
import Token;
import TokenType;
import XmlPrettyPrinter;
import XmlTokenizer;

public class DemoApp {
    public static void main(String[] args) {
        XmlPrettyPrinter printer = new XmlPrettyPrinter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== XML Pretty Printer Demo ===");

        // Примеры для демонстрации
        String[] examples = {
                // 1. Простой валидный XML
                "<root><user><name>John</name><age>30</age></user></root>",

                // 2. Невалидный XML
                "<books><book><title>Book 1<author>Author 1</title></book></books>",

                // 3. XML с комментариями
                "<!-- users list --><users><user id='1'>John</user><!-- admin --><user id='2'>Jane</user></users>",

                // 4. Ввести свой XML
                "custom"
        };

        while (true) {
            System.out.println("\nВыберите пример:");
            System.out.println("1. Простой XML");
            System.out.println("2. Невалидный XML");
            System.out.println("3. XML с комментариями");
            System.out.println("4. Ввести свой XML");
            System.out.println("0. Выход");

            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) break;

            String xml;
            if (choice.equals("4")) {
                System.out.println("Введите XML (для завершения введите пустую строку):");
                StringBuilder input = new StringBuilder();
                String line;
                while (!(line = scanner.nextLine()).isEmpty()) {
                    input.append(line);
                }
                xml = input.toString();
            } else {
                int index = Integer.parseInt(choice) - 1;
                if (index >= 0 && index < examples.length - 1) {
                    xml = examples[index];
                } else {
                    System.out.println("Неверный выбор!");
                    continue;
                }
            }

            // Форматируем и выводим результат
            System.out.println("\n--- Исходный XML ---");
            System.out.println(xml);

            System.out.println("\n--- Форматированный XML ---");
            try {
                String formatted = printer.format(xml);
                System.out.println(formatted);
            } catch (Exception e) {
                System.out.println("Ошибка при форматировании: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Демонстрация завершена!");
    }
}
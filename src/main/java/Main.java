import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию: ");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Получить книгу по номеру");
            System.out.println("3. Удалить книгу по номеру");
            System.out.println("4. Получить книгу по номеру count");
            System.out.println("5. Получить книгу по автору");
            System.out.println("6. Получить все книги");

            String decision = scanner.next();
            switch (decision) {
                case "1":
                    System.out.println("Введите name:");
                    String name = scanner.next();
                    System.out.println("Введите number:");
                    int number = scanner.nextInt();
                    System.out.println("Введите author:");
                    String aothor = scanner.next();
                    System.out.println("Введите count:");
                    System.out.println("Вы добавили книгу!!!!");

                    int count = scanner.nextInt();
                    BookStoreDB.addBook(new Book(name, number, aothor, count));
                    break;

                case "2":
                    System.out.println("Введете number:");
                    int a = scanner.nextInt();
                    BookStoreDB.getByNymber(a);

                    break;

                case "3":
                    System.out.println("Введете number:");
                    int x = scanner.nextInt();
                    BookStoreDB.deleteByNumber(x);
                    break;

                case "4":

                    break;

                case "5":

                    System.out.println("ВВедите Author:");
                    String s = scanner.next();
                    BookStoreDB.getByAuthor(s);
                    break;

                case "6":

                    break;

                default:
                    System.out.println("Вы ввели неверную команду!");
                    break;
            }
        }
    }
}

import java.sql.*;

public class BookStoreDB {

    public static void addBook(Book book) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/book?serverTimezone=Europe/Moscow", "root",
                "12345");
             Statement statement = conn.createStatement()) {
            int row = statement.executeUpdate(addBooks(book));
            System.out.println(row);


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String addBooks(Book book) {

        return "INSERT INTO BOOKSTORE (NAME, NUMBER, AUTHOR, COUNT) " +
                "VALUES ('" + book.getName() + "','" + book.getNumber() +
                "','" + book.getAuthor() + "','" + book.getCount() + "')";
    }



    public static void deleteByNumber(int number) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/book?serverTimezone=Europe/Moscow", "root",
                "12345");
             Statement statement = conn.createStatement()) {
            int row = statement.executeUpdate(deleteByNumbers(number));
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String deleteByNumbers(int number) {
        return "DELETE FROM BOOKSTORE WHERE NUMBER='" + number + "'";

    }



    public static void getByNymber(int numbers) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/book?serverTimezone=Europe/Moscow", "root",
                "12345");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getByNymbers(numbers));
            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int number = resultSet.getInt("NUMBER");
                String Author = resultSet.getString("AUTHOR");
                int count = resultSet.getInt("COUNT");

                Book book = new Book();
                book.setId(id);
                book.setName(name);
                book.setNumber(number);
                book.setAuthor(Author);
                book.setCount(count);

                System.out.println(book);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static String getByNymbers(int number) {
        return "SELECT * FROM BOOKSTORE WHERE NUMBER='" + number + "'";
    }




    public static void getByAuthor(String Authors) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/book?serverTimezone=Europe/Moscow", "root",
                "12345");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getByAuthors(Authors));
            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int number = resultSet.getInt("NUMBER");
                String Author = resultSet.getString("AUTHOR");
                int count = resultSet.getInt("COUNT");

                Book book = new Book();
                book.setId(id);
                book.setName(name);
                book.setNumber(number);
                book.setAuthor(Author);
                book.setCount(count);

                System.out.println(book);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static String getByAuthors(String Author) {
        return "SELECT * FROM BOOKSTORE WHERE AUTHOR='" + Author + "'";
    }
}

import java.sql.*;


public class DBUtils {
    public static void getConnection() {
        String sql = "SELECT * FROM BOOKSTORE";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/book?serverTimezone=Europe/Moscow", "root",
                "12345");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
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


        } catch (Exception e) {
            System.out.println(e);

        }


    }

}


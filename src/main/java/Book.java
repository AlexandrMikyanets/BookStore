public class Book {
    private int id;
    private String name;
    private int number;
    private String Author;
    private int count;

    public Book() {
    }

    public Book(String name, int number, String author, int count) {
        this.name = name;
        this.number = number;
        Author = author;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", Author='" + Author + '\'' +
                ", count=" + count +
                '}';
    }
}

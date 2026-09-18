import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class IdCardDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String studentName = scanner.next();
            int initialBooks = scanner.nextInt();

            IdCard ravi = new IdCard(studentName, initialBooks);
            IdCard duplicate = ravi; // Reference assignment

            int updatedBooks = scanner.nextInt();
            duplicate.booksIssued = updatedBooks;

            System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
            System.out.println("duplicate == ravi: " + (duplicate == ravi));

            IdCard separate = new IdCard(studentName, updatedBooks);
            System.out.println("separate == ravi: " + (separate == ravi));
        } catch (Exception e) {
            System.out.println("Error tracking ID cards: " + e.getMessage());
        }
    }
}
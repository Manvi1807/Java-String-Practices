import java.util.Scanner;

class BookInventory {
    private String title;
    private String author;
    private int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(this.title + " by " + this.author + " " + this.copiesAvailable + " copies available");
    }
}

public class LibraryInventoryDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalBooks = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            BookInventory[] inventory = new BookInventory[totalBooks];

            for (int i = 0; i < totalBooks; i++) {
                String title = scanner.nextLine().trim();
                String author = scanner.nextLine().trim();
                int copies = scanner.nextInt();
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Consume newline
                }
                inventory[i] = new BookInventory(title, author, copies);
            }

            for (BookInventory book : inventory) {
                book.printEntry();
            }
        } catch (Exception e) {
            System.out.println("Error processing library inventory: " + e.getMessage());
        }
    }
}
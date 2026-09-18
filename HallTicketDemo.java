import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.next();
            int initialSeat = scanner.nextInt();

            HallTicket priya = new HallTicket(name, initialSeat);
            HallTicket copy = priya; // Reference copy

            int updatedSeat = scanner.nextInt();
            copy.seatNumber = updatedSeat;

            System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
            System.out.println("copy == priya: " + (copy == priya));

            HallTicket separate = new HallTicket(name, updatedSeat);
            System.out.println("separate == priya: " + (separate == priya));
        } catch (Exception e) {
            System.out.println("Error tracking hall tickets: " + e.getMessage());
        }
    }
}
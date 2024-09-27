public class TicketService {

    public static void main(String[] args) {

    Ticket ticket1 = new Ticket();
    Ticket ticket2 = new Ticket("Theatre", 123, "18:00");
    Ticket ticket3 = new Ticket("Circus", 56,"20:30", true, 'B', 2.5);

    ticket3.setPrice(50);

    ticket1.printTicket();
    ticket2.printTicket();
    ticket3.printTicket();

    }
}

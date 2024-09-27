import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ticket {
    private static int ticketsCounter = 1;
    private static final SimpleDateFormat DateAndTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm");
    private static final DecimalFormat formatter = new DecimalFormat("$#,##0.00");

    private int ticketId = 0;
    private Timestamp ticketCreationTime;
    private String concertHall;
    private int eventCode;
    private Timestamp eventTime;
    private boolean isPromo;
    private char stadiumSector;
    private double backpackAllowedWeight;
    private BigDecimal price;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getTicketCreationTime() {
        return ticketCreationTime;
    }

    public void setTicketCreationTime() {
        this.ticketCreationTime = new Timestamp(System.currentTimeMillis());
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall.length() > 10 ) {
            System.out.println("Invalid concert hall name.");
            System.exit(0);
        }
        this.concertHall = concertHall;
    }

    public void setUnnamedConcertHall() {
        this.concertHall = "-";
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        if (Integer.toString(eventCode).length() > 3) {
            System.out.println("Invalid event code");
            System.exit(0);
        }
        this.eventCode = eventCode;
    }

    public void setUnnamedEventCode() {

    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        try {
            java.util.Date parsedDate = TimeFormat.parse(eventTime);
            this.eventTime = new Timestamp(parsedDate.getTime());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector != 'A' & stadiumSector != 'B' & stadiumSector != 'C') {
            System.out.println("Invalid stadium sector");
            System.exit(0);
        }
        this.stadiumSector = stadiumSector;
    }

    public void setUnnamedStadiumSector() {
        this.stadiumSector = '-';
    }

    public double getbackpackAllowedWeight() {
        return backpackAllowedWeight;
    }

    public void setbackpackAllowedWeight(double backpackAllowedWeight) {
        if (backpackAllowedWeight < 0) {
            System.out.println("Invalid backpack weight.");
            System.exit(0);
        }
        this.backpackAllowedWeight = backpackAllowedWeight;
    }

    public String getPrice() {
        return formatter.format(this.price);
    }

    public void setPrice(Integer price) {
        if (price < 0 )
        {
            System.out.println("Invalid price.");
            System.exit(0);
        }
        else {
            this.price = new BigDecimal(price);
        }
    }

    public Ticket() {
        ticketId = ticketsCounter;
        ticketsCounter++;
        setTicketCreationTime();
        setUnnamedConcertHall();
        setPromo(false);
        setUnnamedStadiumSector();
        setbackpackAllowedWeight(0);
    }

    public Ticket(String concertHall, int eventCode, String eventTime) {
        ticketId = ticketsCounter;
        ticketsCounter++;
        setTicketCreationTime();
        setPromo(false);
        setUnnamedStadiumSector();
        setbackpackAllowedWeight(0);

        setConcertHall(concertHall);
        setEventCode(eventCode);
        setEventTime(eventTime);
    }

    public Ticket(String concertHall, int eventCode, String eventTime, boolean isPromo, char stadiumSector, double backpackAllowedWeight) {
        ticketId = ticketsCounter;
        ticketsCounter++;
        setTicketCreationTime();

        setConcertHall(concertHall);
        setEventCode(eventCode);
        setEventTime(eventTime);
        setPromo(isPromo);
        setStadiumSector(stadiumSector);
        setbackpackAllowedWeight(backpackAllowedWeight);
    }
    
    public void printTicket() {
        System.out.println("----------------");
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Ticket created: " + DateAndTimeFormat.format(getTicketCreationTime()));
        System.out.println("Concert Hall: " + getConcertHall());
        System.out.println("Event Code: " + getEventCode());

        if (eventTime != null) {
            System.out.println("Event Time: " + TimeFormat.format(getEventTime()));
        }
        else {
            System.out.println("Event Time: -");
        }

        if (isPromo()) {
            System.out.println("Promo: Yes");
        }
        else {
            System.out.println("Promo: No");
        }
        System.out.println("Stadium Sector: " + getStadiumSector());
        System.out.println("Allowed Backpack Weight: " + getbackpackAllowedWeight() + "kg");

        if (price != null) {
            System.out.println("Price: " + getPrice());
        }
        else {
            System.out.println("Price: -");
        }
        System.out.println("----------------");

    }
}

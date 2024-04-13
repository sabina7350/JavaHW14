import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTicketsCompareToMultipleReturns() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Moscow", "Kazan");
        Ticket[] expected = {ticket2, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithoutResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Ufa", "Chelyabinsk");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsWithOneResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("Moscow", "Ufa");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Kazan", "Moscow", comparator);
        Ticket[] expected = {ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorWithoutResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Chelyabinsk", "Kazan", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorWithOneResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Kazan", 2_500, 16, 18);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 2_000, 15, 17);
        Ticket ticket4 = new Ticket("Moscow", "Ufa", 3_000, 16, 18);
        Ticket ticket5 = new Ticket("Moscow", "Kazan", 2_750, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Moscow", "Ufa", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
}
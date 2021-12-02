package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket first = new Ticket(1, 1000, 24, "MOW", "PMM");
    private Ticket second = new Ticket(2, 1500, 24, "MOW", "PMM");
    private Ticket third = new Ticket(3, 2000, 24, "SEE", "LED");
    private Ticket forth = new Ticket(4, 2000, 24, "SEE", "LED");
    private Ticket fifth = new Ticket(5, 2500, 24, "SEE", "LED");
    private Ticket sixth = new Ticket(6, 2500, 24, "MOW", "PMM");

    @BeforeEach
    public void set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSortByPrice() {
        Ticket[] actual = manager.findAllFromTo("MOW", "PMM");
        Ticket[] expected = new Ticket[]{first, second, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByPriceWithDifferentFromTo() {
        Ticket[] actual = manager.findAllFromTo("MOW", "SEE");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByEqualPrice() {
        Ticket[] actual = manager.findAllFromTo("SEE", "LED");
        Ticket[] expected = new Ticket[]{third, forth, fifth};

        assertArrayEquals(expected, actual);
    }

}
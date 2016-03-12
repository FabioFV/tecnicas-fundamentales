package lab2.test;

import lab2.Item;

import static org.junit.Assert.*;

public class ItemTest {

    @org.junit.Test
    public void testCalculateShippingRate() throws Exception {
        Item item1 = new Item("Thinking in Java", "Book", 38.0);
        Item item2 = new Item("Axix Cube", "Toy", 9.45);
        Item item3 = new Item("SDD", "Electronic", 250.59);
        Item item4 = new Item("The Book", "Book", 1000.00);
        assertEquals(0.0, item1.calculateShippingRate(), 0.000001);
        assertEquals(0.4725, item2.calculateShippingRate(), 0.000001);
        assertEquals(5.0, item3.calculateShippingRate(), 0.000001);
        assertEquals(0.0, item4.calculateShippingRate(), 0.000001);
    }
}
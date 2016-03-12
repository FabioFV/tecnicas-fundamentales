package lab2;

public class Main {

    public static void main(String args[])
    {
        Item item1 = new Item("Thinking in Java", "Book", 38.0);
        System.out.println("Total: " + (item1.getCost() + item1.calculateShippingRate()));
    }

}

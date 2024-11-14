package de.breuninger.breuniinterview;

import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CheckoutService {
    private Map<String, Item> cart = new HashMap<>();
    private ItemRepository itemRepository = new ItemRepository();
    private PaymentService paymentService = new PaymentService();

    public void addItemToCart(String itemId) {
        Item item = itemRepository.getItemById(itemId);
        cart.put(itemId, item);
        System.out.println("Item added to cart: " + item.name());
    }

    public double checkout(String paymentDetails) {
        double total = 0;
        for (String itemId : cart.keySet()) {
            total += cart.get(itemId).price();
        }
        paymentService.processPayment(total, paymentDetails);
        System.out.println("Checkout complete. Total amount: $" + total);
        return total;
    }

    public Collection<Item> getCart(){
        return cart.values();
    }

    public void applyVoucher(String voucherCode) {

    }


    // Items and repositories are dummy implementations for example purposes
    public record Item(String id, String name, double price) {
    }

    // Dummy implementation for example purposes
    public static class ItemRepository {

        public Item getItemById(String itemId) {
            // Dummy implementation for example purposes
            return new Item(itemId, "Sample Item", 19.99);
        }
    }

    // Dummy implementation for example purposes
    public static class PaymentService {

        public void processPayment(double amount, String paymentDetails) {
            // Dummy implementation for example purposes
            System.out.println("Processed payment of $" + amount);
        }
    }
}


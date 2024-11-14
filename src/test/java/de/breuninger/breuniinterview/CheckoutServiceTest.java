package de.breuninger.breuniinterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CheckoutServiceTest {

    @Test
    void testAddItemToCart() {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.addItemToCart("item123");

        final var cart = checkoutService.getCart();

        assertEquals(1, cart.size());
    }

    @Test
    void testCheckoutWithoutVoucher() {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.addItemToCart("item123");
        checkoutService.addItemToCart("item125");

        final var total = checkoutService.checkout("validPaymentInfo");

        assertEquals(39.98, total);
    }

    // Additional test to be extended by the candidate
    @Test
    void testApplyVoucher() {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.addItemToCart("item123");
        checkoutService.applyVoucher("VOUCHER_CODE");

        final var total = checkoutService.checkout("validPaymentInfo");

        // TODO: Extend this test to apply an invalid voucher code and verify exception handling
    }
}
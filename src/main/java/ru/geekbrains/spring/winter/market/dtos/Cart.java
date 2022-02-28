package ru.geekbrains.spring.winter.market.dtos;

import lombok.Data;
import ru.geekbrains.spring.winter.market.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        for (CartItem cartItem : items) {
            if (cartItem.getProductId().equals(product.getId())) {
                cartItem.incrementQuantity();

                recalculate();

                return;
            }
        }

        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));

        recalculate();
    }

    public void clear() {
        items.clear();

        recalculate();
    }

    public void decrement(Product product) {
        for (CartItem cartItem : items) {
            if (cartItem.getProductId().equals(product.getId())) {
                cartItem.decrementQuantity();

                recalculate();

                return;
            }
        }

        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));

        recalculate();
    }

    public void removeFromCart(Long productId) {
        items.removeIf(item -> productId.equals(item.getProductId()));

        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }
}

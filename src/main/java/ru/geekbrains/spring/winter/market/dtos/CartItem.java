package ru.geekbrains.spring.winter.market.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public void incrementQuantity() {
        quantity += 1;
        price = pricePerProduct * quantity;
    }

    public void decrementQuantity() {
        if (quantity <= 1)
            return;

        quantity -= 1;
        price = pricePerProduct * quantity;
    }
}

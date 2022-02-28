package ru.geekbrains.spring.winter.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.winter.market.dtos.Cart;
import ru.geekbrains.spring.winter.market.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clear();
    }

    @GetMapping("/decrement/{id}")
    public void decrementProduct(@PathVariable Long id) {
        cartService.decrement(id);
    }

    @GetMapping("/remove")
    public void removeFromCart(@RequestParam Long productId) {
        cartService.removeFromCart(productId);
    }
}

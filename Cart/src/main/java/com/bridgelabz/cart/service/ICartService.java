package com.bridgelabz.cart.service;

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.entity.Cart;

import java.util.List;

public interface ICartService {
    public Cart insertCart(CartDTO cartdto);
    public List<Cart> getAllCartRecords();
    public Cart getCartRecord(Integer id);
    public Cart updateCartRecord(Integer id, CartDTO dto);
    public Cart deleteCartRecord(Integer id);
    public Cart updateQuantity(Integer id, Integer quantity);
    public List<Cart> deleteAllFromCart();
}

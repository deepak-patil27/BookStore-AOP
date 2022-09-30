package com.bridgelabz.cart.service;

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.entity.Cart;
import com.bridgelabz.cart.exception.BookStoreException;
import com.bridgelabz.cart.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class CartService implements ICartService{
    @Autowired
    private CartRepository cartRepo;

    public Cart insertCart(CartDTO cartdto) {
                Cart newCart = new Cart(cartdto.getQuantity(), cartdto.getBookID(), cartdto.getUserID());
                cartRepo.save(newCart);
                log.info("Cart record inserted successfully");
                return newCart;
            }
    //Ability to serve to controller's retrieve all cart records api call
    public List<Cart> getAllCartRecords(){
        List<Cart> 	cartList = cartRepo.findAll();
        log.info("All cart records retrieved successfully");
        return cartList;
    }
    //Ability to serve to controller's retrieve cart record by id api call
    public Cart getCartRecord(Integer id) {
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        }
        else {
            log.info("Cart record retrieved successfully for id "+id);
            return cart.get();
        }
    }
    //Ability to serve to controller's update cart record by id api call
    public Cart updateCartRecord(Integer id,CartDTO dto) {
                    Cart newCart = new Cart(id,dto.getQuantity(), dto.getUserID(), dto.getBookID());
                    cartRepo.save(newCart);
                    log.info("Cart record updated successfully for id "+id);
                    return newCart;
                }

    //Ability to serve to controller's delete cart record by id api call
    public Cart deleteCartRecord(Integer id) {
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        }
        else {
            cartRepo.deleteById(id);
            log.info("Cart record deleted successfully for id "+id);
            return cart.get();
        }
    }
    //Ability to serve to controller's update quantity of books in cart api call
    public Cart updateQuantity(Integer id, Integer quantity) {
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        }
        else {
                cart.get().setQuantity(quantity);
                cartRepo.save(cart.get());
                log.info("Quantity in cart record updated successfully");
                return cart.get();
            }
        }

    //Created service method which serves controller api to delete all quantity
    public List<Cart> deleteAllFromCart() {

        cartRepo.deleteAll();
        return cartRepo.findAll();
    }

}

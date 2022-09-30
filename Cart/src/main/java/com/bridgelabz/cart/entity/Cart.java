package com.bridgelabz.cart.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartID;
    private Integer userID;

    private Integer bookID;
    private Integer quantity;

    public Cart(Integer cartID,Integer quantity, Integer bookID, Integer userID) {
        this.cartID= cartID;
        this.quantity = quantity;
        this.bookID=bookID;
        this.userID=userID;
    }
    public Cart(Integer quantity, Integer bookID, Integer userID) {
        this.quantity = quantity;
        this.bookID=bookID;
        this.userID=userID;
    }

}

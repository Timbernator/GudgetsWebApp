/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.entity;

/**
 *
 * @author LAB0033BPC22
 */
public class Item {
    private Product product;
    private double subTot;
    private double total;
    private int quantity = 1;

    public Item() {
    }

    public Item(Product product, double subTot, double Total) {
        this.product = product;
        this.subTot = subTot;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSubTot() {
        return subTot;
    }

    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double calcSubTotal()
    {
        return subTot = quantity*product.getPrice();
    }
    public double calcTotalAmnt()
    {
        return total +=subTot; 
    }
    
}

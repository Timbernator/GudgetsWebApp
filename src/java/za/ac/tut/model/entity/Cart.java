package za.ac.tut.model.entity;

import java.util.List;
import java.util.Vector;

public class Cart
{
    private List<Product> products;
    
    public Cart() {
        products = new Vector<Product>();
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void addToCart(Product product)
    {
        products.add(product);
    }
    
    public int count()
    {
        return products.size();
    }  
    
    public void removeProduct(String code)
    {
        for (int x = 0;x < products.size();x++)
        {
            if (products.get(x).getCode().equals(code))
            {
                products.remove(x);
            }
        }
    }
    
    public void updateProduct(Product product, int num)
    {
 
                for(int z =0; z < num; z++)
                {
                    addToCart(product);
                }

    }
    public double getTotal()
    {
        double total = 0;
       
        for(int x = 0; x < products.size();x++)
        {
            total += products.get(x).getPrice();
        
        }
        
        return total;
    }

}

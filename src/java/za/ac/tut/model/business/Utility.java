/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.business;

import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.entity.Account;
import za.ac.tut.model.entity.Cart;
import za.ac.tut.model.entity.Login;
import za.ac.tut.model.entity.Product;

/**
 *
 * @author LAB0033BPC22
 */
public class Utility {
    public static List<Product> products;

    public static String verifyBank(String accountNumber, String bankName, String branchCode, double amount, HttpSession session, AccountFacadeLocal accountFacade) {
        String url = "";
        List<Account> accounts = accountFacade.findAll();
        
        for(int x =0;x<accounts.size();x++)
        {
            Account acc = new Account();
            if(accounts.get(x).getAccNum().equalsIgnoreCase(accountNumber) && accounts.get(x).getBankName().equalsIgnoreCase(bankName))
            {
                double transaction = accounts.get(x).getBalance()-amount;
               acc = new Account(bankName, branchCode, bankName, transaction);
                
                session.setAttribute("account", acc);
                
                url = "accountNotFound.jsp";
            }
            else
            { 
                session.setAttribute("account", acc);
                
                url = "OderConfirmed.jsp";
            }
        }
        return url;
    }
    public List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }



    public static void pushToCart(String code, int quantity, HttpSession session, ProductFacadeLocal productFacade,HttpServletRequest request) {
         products = productFacade.findAll();
         Cart cart =(Cart) session.getAttribute("cart");
        
        for(Product prod : products)
        {
            if(prod.getCode().equalsIgnoreCase(code))
            {
                cart.updateProduct(prod, quantity);
            }
        }
        session.setAttribute("cart", cart);
        request.setAttribute("session", session);
        
        
        
    }
    public Utility(){
       accounts = new Vector<Account>();
       products = new Vector<>();
       products.add(new Product("Acer1", "img/Acer-budget.jpg", "Acer Budget", "Year:2010,Processor:1.8Ghz,ScreenSize:15'6,HDD:320Gb, RAM:2Gb", 2000));
        products.add(new Product("Acer2", "img/Acer_Aspire.jpg", "Acer Aspire", "Year:2012,Processor:2.1Ghz,ScreenSize:14'5,HDD:500Gb, RAM:2Gb", 3500));
        products.add(new Product("Apple1", "img/Apple Rainbow.jpg", "Apple Rainbow", "Year:2014,Processor:2.5Ghz,ScreenSize:15'8,HDD:500Gb, RAM:4Gb", 8500));
        products.add(new Product("Apple2", "img/Apple-Macbook-Pro.jpg", "Apple Macbook Pro", "Year:2015,Processor:3.2Ghz,ScreenSize:15'8,HDD:500Gb, RAM:8Gb", 11000));
        products.add(new Product("Apple3", "img/Apple_hero.jpg", "Apple Hero", "Year:2017,Processor:3.8Ghz,ScreenSize:15'6,HDD:1Tb, RAM:8Gb", 15000));
        products.add(new Product("Acer3", "img/Acer-AspirePro.jpg", "Acer Aspire Pro", "Year:2016,Processor:2.8Ghz,ScreenSize:14'5,HDD:500Gb, RAM:4Gb", 4500));
        products.add(new Product("Compaq1", "img/Compaq.jpg", "Compaq Asha", "Year:2016,Processor:2.2Ghz,ScreenSize:15'2,HDD:500Gb, RAM:8Gb", 4800));
        products.add(new Product("HP1", "img/Hp_essential.jpg", "HP Essential", "Year:2014,Processor:2.6Ghz,ScreenSize:15'8,HDD:1Tb, RAM:4Gb", 5000));
        products.add(new Product("HP2", "img/Hp_workstation.jpg", "HP WorkStation", "Year:2015,Processor:2.8Ghz,ScreenSize:15'6,HDD:320Gb, RAM:4Gb", 3500));
        products.add(new Product("lenovo1", "img/Lenovo-2016.jpg", "Lenovo Orange", "Year:2017,Processor:3.2Ghz,ScreenSize:15'6,HDD:400Gb, RAM:2Gb", 4400));
        
        products.add(new Product("Lenovo2", "img/Lenovo-G210.jpg", "Lenovo G210", "Year:2011,Processor:2.1Ghz,ScreenSize:15'6,HDD:360Gb, RAM:4Gb", 6000));
        products.add(new Product("Levovo3", "img/Lenovo-ThinkPad-Edge.jpg", "Lenovo ThinkPad Edge", "Year:2013,Processor:2.0Ghz,ScreenSize:14'5,HDD:500Gb, RAM:2Gb", 3500));
        products.add(new Product("Lenovo4", "img/Lenovo-Y70.jpg", "Lenovo Y70", "Year:2015,Processor:2.5Ghz,ScreenSize:15'8,HDD:500Gb, RAM:4Gb", 4500));
        products.add(new Product("Lenovo5", "img/Lenovo-yoga-900.jpg", "Lenovo Yoga", "Year:2015,Processor:3.2Ghz,ScreenSize:15'8,HDD:500Gb, RAM:8Gb", 6500));
        products.add(new Product("Sony1", "img/Sony-Viao.jpg", "Sony Viao 2015", "Year:2015,Processor:3.8Ghz,ScreenSize:15'6,HDD:1Tb, RAM:8Gb", 7000));
        products.add(new Product("Toshoba1", "img/Toshiba_netbuk.jpg", "Toshiba Netbuk", "Year:2009,Processor:1.8Ghz,ScreenSize:14'5,HDD:280Gb, RAM:4Gb", 1500));
        products.add(new Product("acer4", "img/acer-2010.jpg", "Acer Ray", "Year:2016,Processor:2.2Ghz,ScreenSize:15'2,HDD:500Gb, RAM:8Gb", 2800));
        products.add(new Product("Apple4", "img/apple-purple.jpg", "Apple Purple", "Year:2014,Processor:3.6Ghz,ScreenSize:15'8,HDD:1Tb, RAM:4Gb", 9000));
        products.add(new Product("Dell1", "img/dell 2011.jpg", "Dell Rain", "Year:2015,Processor:2.8Ghz,ScreenSize:15'6,HDD:320Gb, RAM:4Gb", 3500));
        products.add(new Product("Dell2", "img/dell-inspiron.jpg", "Dell Inspiron", "Year:2017,Processor:3.2Ghz,ScreenSize:15'6,HDD:400Gb, RAM:2Gb", 5500));
        
        products.add(new Product("Dell3", "img/dell_max.jpg", "Dell Max", "Year:2015,Processor:2.1Ghz,ScreenSize:15'6,HDD:360Gb, RAM:4Gb", 4000));
        products.add(new Product("Fujitsu1", "img/fujitsu.jpg", "Fujitsu Live", "Year:2014,Processor:2.0Ghz,ScreenSize:14'5,HDD:500Gb, RAM:2Gb", 3500));
        products.add(new Product("Gateway", "img/gateway.jpg", "Gateway sky", "Year:2014,Processor:2.5Ghz,ScreenSize:15'8,HDD:500Gb, RAM:4Gb", 4500));
        products.add(new Product("HP3", "img/HP-servisi.jpg", "HP servisi", "Year:2016,Processor:3.2Ghz,ScreenSize:15'8,HDD:500Gb, RAM:8Gb", 6500));
        products.add(new Product("Lenovo6", "img/lenoZ830.jpg", "Lenovo Z830", "Year:2016,Processor:3.8Ghz,ScreenSize:15'6,HDD:1Tb, RAM:8Gb", 7000));
        products.add(new Product("Lenovo7", "img/lenovo-ideapad-2012.jpg", "Lenovo Ideapad ", "Year:2012,Processor:2.8Ghz,ScreenSize:14'5,HDD:480Gb, RAM:4Gb", 3500));
        products.add(new Product("Lenovo8", "img/lenovo-2009.jpg", "lenovo Oct", "Year:2009,Processor:2.2Ghz,ScreenSize:15'2,HDD:500Gb, RAM:8Gb", 3200));
        products.add(new Product("Lenovo9", "img/lenovo-u300.jpg", "Lenovo U300", "Year:2014,Processor:3.2Ghz,ScreenSize:15'8,HDD:1Tb, RAM:4Gb", 7000));
        products.add(new Product("Sony2", "img/sony-design_sf.jpg", "Sony Blade", "Year:2014,Processor:3.8Ghz,ScreenSize:15'6,HDD:320Gb, RAM:4Gb", 3500));
        products.add(new Product("Sony3", "img/sony-vaio-2013.jpg", " Sony Color", "Year:2015,Processor:2.2Ghz,ScreenSize:15'6,HDD:400Gb, RAM:2Gb", 5500));
        
        accounts.add(new Account("capitec", "1010", "23052017", 50000));
        accounts.add(new Account("standard", "2020", "22052017", 60000));
        accounts.add(new Account("nedbank", "3030", "21052017", 70000));
        accounts.add(new Account("fnb", "4040", "20052017", 90000));
        accounts.add(new Account("absa", "5050", "19052017", 100000));
   
    }


    public static void pushToCart(String code, HttpSession session) {
        
        Cart cart = (Cart)session.getAttribute("cart");
        List<Product> prod = cart.getProducts();
        for(int x = 0;x< prod.size();x++)
        {
            Product product = prod.get(x);
            if(product.getCode().equalsIgnoreCase(code))
            {
                cart.addToCart(product);
                session.setAttribute("cart", cart);
            }
        }        
    }
    
    public static String verifyLogin(String username, String password, HttpSession session, LoginFacadeLocal loginFacade, ProductFacadeLocal productFacade) {
         String url = "";
        List<Login> logins = loginFacade.findAll();
        
       
        for(int x =0;x<logins.size();x++)
        {
            
            if(logins.get(x).getUsername().equalsIgnoreCase(username) && logins.get(x).getPassword().equalsIgnoreCase(password))
            {
                     

                    List<Product> prods = productFacade.findAll();
                    session.setAttribute("products", prods);
                    session.setAttribute("login", logins.get(x)); 
                    url = "ViewProducts.jsp";  
            }
            else
            {
                url = "PasswordNotFound.jsp";
            }
        }

        return url;
    }

    

    public static void addToDatabase(ProductFacadeLocal productFacade) {
         Utility util = new Utility();
            if(productFacade.findAll().isEmpty())
            {
                List<Product> products = util.getProducts();
                
                for(int z = 0; z < products.size(); z++)
                {
                    
                    productFacade.create(products.get(z));
                    
                }
            }
    }
        public static void addAccounts(AccountFacadeLocal accountFacade) {
         Utility util = new Utility();
            if(accountFacade.findAll().isEmpty())
            {
                List<Account> accounts = util.getAccounts();
                
                for(int z = 0; z < accounts.size(); z++)
                {
                    
                    accountFacade.create(accounts.get(z));
                    
                }
            }
    }


    
    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(Vector<Product> products) {
        Utility.products = products;
    }

    
}

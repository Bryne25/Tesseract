/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;

/**
 *
 * @author TEST
 */
public class transactions {
    String cashName,custFname,custLname,date,itemName;
    int transactionId,itemQuant, total, itemPrice;

    public transactions(int transactionId, String cashName, String custFname, String custLname, String date, String itemName, int itemQuant, int itemPrice) {
        this.transactionId = transactionId;
        this.cashName = cashName;
        this.custFname = custFname;
        this.custLname = custLname;
        this.date = date;
        this.itemName = itemName;
        this.itemQuant = itemQuant;
        this.itemPrice = itemPrice;
        this.total = this.itemPrice * this.itemQuant;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getCashName() {
        return cashName;
    }

    public void setCashName(String cashName) {
        this.cashName = cashName;
    }

    public String getCustFname() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuant() {
        return itemQuant;
    }

    public void setItemQuant(int itemQuant) {
        this.itemQuant = itemQuant;
    }


    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    
}

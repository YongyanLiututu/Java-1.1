package com.mycompany.iotbay1.models;


public class Product {

  private String productId;
  private String productName;
  private String productYtpe;
  private double productPrice;


  public int getProductquantity() {
    return productquantity;
  }

  public void setProductquantity(int productquantity) {
    this.productquantity = productquantity;
  }

  private int productquantity;



  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProducttype() {
    return productYtpe;
  }

  public void setProducttype(String productYtpe) {
    this.productYtpe = productYtpe;
  }


  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

}

package cn.itcast.order.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
public class Product {

  @Id
  private long id;
  private String productName;
  private long status;
  private double price;
  private String productDesc;
  private String caption;
  private long inventory;


}

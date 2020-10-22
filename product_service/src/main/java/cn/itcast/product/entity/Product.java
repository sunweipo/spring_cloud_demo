package cn.itcast.product.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
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

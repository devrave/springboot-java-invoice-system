package com.andres.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // se usa para marcar una clase como un componente gestionado por el contenedor de Spring (el IoC container).
public class Invoice {

  @Autowired
  private Client client;

  @Value("${invoice.description}")
  private String description;

  @Autowired
  private List<Item> Items;


  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public List<Item> getItems() {
    return Items;
  }
  public void setItems(List<Item> items) {
    Items = items;
  }

  public int getTotal(){
    //----iteracion usando un for each
    // int total = 0;
    // for (Item item : Items){
    //    total += item.getImporte();
    // }
   
    //OTRA MANERA ES USANDO EL API STREAM, PROGRAMACION FUNCIONAL

    int total = Items.stream()
    .map(item -> item.getImporte())
    .reduce(0,(sum, importe) -> sum + importe);
    return total;
  }


  



}

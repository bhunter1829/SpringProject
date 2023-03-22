package Inventory.Controller;

import Inventory.Model.Inventory;
import Inventory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
(Projects of Spring)
spring MVC
Spring data JPA
Spring AOP
Spring Core
Spring Boot
Spring ORM
 */
@RestController
public class InventoryController {
    InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
     @GetMapping ("inventory")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();

     }

     @GetMapping("inventory/{id}")
         public Inventory getInventoryById(@PathVariable("id") long id){
         return inventoryService.getInventoryById(id);
     }

     @PostMapping("inventory")
        public Inventory addInventory(@RequestBody Inventory inventory) {
         return this.inventoryService.addInventory(inventory);
     }
     @DeleteMapping("inventory/{id}")
        public Inventory deleteInventoryByid(@PathVariable("id") long id) {
        return inventoryService.deleteInventoryById(id);
     }
     /*
     user stories
     as a user I should submit a inventory submission
     as a user I should be able to view all inventory
      */
}

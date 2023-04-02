package Inventory.Controller;

import Inventory.Model.Inventory;
import Inventory.Projections.InventoryI;
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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
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

    @GetMapping ("namesInventory")
    public List<InventoryI> getNamesInventory(){
        return inventoryService.getNamesInventory();

    }

    @GetMapping ("inventory/{name}")
    public List<Inventory> getInventoryByName(@PathVariable("name") String name){
        return inventoryService.getInventoryByName(name);

    }



     @GetMapping("id/{id}")
         public Inventory getInventoryById(@PathVariable("id") long id){
         return inventoryService.getInventoryById(id);
     }

     @PostMapping("inventory")
        public Inventory addInventory(@RequestBody Inventory inventory) {
         return this.inventoryService.addInventory(inventory);
     }
//     @DeleteMapping("inventory/{id}")
//        public Inventory deleteInventoryByid(@PathVariable("id") long id) {
//        return inventoryService.deleteInventoryById(id);
//     }

     @DeleteMapping("inventory/remove/{names}")
        public void deleteInventoryByName(@PathVariable String names){
         inventoryService.deleteInventoryByName(names);
     }
     /*
     user stories
     as a user I should submit a inventory submission
     as a user I should be able to view all inventory
      */

    @GetMapping("count")
    public long getCount() {
        return inventoryService.count();
    }

    @GetMapping("sum")
    public int getSum() {
        return inventoryService.sum();
    }

}

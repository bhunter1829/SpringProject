package Inventory.Controller;

import Inventory.Model.Inventory;
import Inventory.Projections.InventoryI;
import Inventory.Service.InventoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
//@CrossOrigin(origins = {"http://ec2-54-204-180-31.compute-1.amazonaws.com:4200/", "http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class InventoryController {
    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    //get endpoint, returns everything in inventory table
     @GetMapping ("inventory")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();

     }
    //get endpoint, returns just the names in inventory table
    @GetMapping ("namesInventory")
    public List<InventoryI> getNamesInventory(){
        return inventoryService.getNamesInventory();

    }
    //get endpoint, returns inventory by matching name
    @GetMapping ("inventory/{name}")
    public List<Inventory> getInventoryByName(@PathVariable("name") String name){
        return inventoryService.getInventoryByName(name);

    }
    //patch endpoint, updates inventory by name, and updates amount
    @PatchMapping ("inventory/{name}/{amount}")
    public void getInventoryByName(@PathVariable("name") String name, @PathVariable("amount") int amount){
       inventoryService.patchAmount(name, amount);
    }

    //get endpoint, gets inventory ID
     @GetMapping("id/{id}")
         public Inventory getInventoryById(@PathVariable("id") long id){
         return inventoryService.getInventoryById(id);
     }
    //post endpoint, adds new data to inventory table
     @PostMapping("inventory")
        public Inventory addInventory(@RequestBody Inventory inventory) {
         return this.inventoryService.addInventory(inventory);
     }

    //delete endpoint, deletes data from inventory by matching name
     @DeleteMapping("inventory/remove/{names}")
        public void deleteInventoryByName(@PathVariable String names){
         inventoryService.deleteInventoryByName(names);
     }

    //get endpoint, returns sql count of inventory, # of individual items
    @GetMapping("count")
    public long getCount() {
        return inventoryService.count();
    }

    //get endpoint, returns sql sum of inventory amount column
    @GetMapping("sum")
    public int getSum() {
        return inventoryService.sum();
    }

}

package Inventory.Service;

import Inventory.Model.Inventory;
import Inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

//components are classes that spring boot detects and loads in its IOC container
//conversion of Control
public class InventoryService {
    InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    /*
    This  will get our entire inventory
     */
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }
    /*
    this will get a single inventory item by its id
     */
    public Inventory getInventoryById(long id){
            return inventoryRepository.findById(id).get();
    }
    /*
    this will let us add an Inventory item
     */
    public Inventory addInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
    /*
    this will delete an inventory by its id
     */
    public void deleteInventoryById(long id){
         inventoryRepository.deleteById(id);
    }

}



//repository
//public interface name extends JpaRepository<Inventory, Int>{


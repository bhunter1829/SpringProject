package Inventory.Service;

import Inventory.Model.Inventory;

import Inventory.Projections.InventoryI;
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
    public List<InventoryI> getNamesInventory(){
        return inventoryRepository.findNames();
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
    public long count(){ return inventoryRepository.count(); }

    public int sum(){ return inventoryRepository.sum(); }
    public Inventory addInventory(Inventory inventory){
        return inventoryRepository.save(inventory);

    }
    /*
    this will delete an inventory by its id
     */
    public Inventory deleteInventoryById(long id){
         inventoryRepository.deleteById(id);
        return null;
    }

    public void  deleteInventoryByName(String name){
            inventoryRepository.deleteByName(name.toUpperCase());
        }

    public List<Inventory> getInventoryByName(String name) {
        return inventoryRepository.findAllByName(name);
    }

    public Inventory patchAmount(String name, int amount){
        inventoryRepository.updateAmount(name, amount);
        return null;
    }
//    public List<Inventory> getInventoryByName(String name){
//            return inventoryRepository.findAllByName(name);
//
//
//    }

}



//repository
//public interface name extends JpaRepository<Inventory, Int>{


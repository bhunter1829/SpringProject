package Inventory.Repository;

import Inventory.Model.Inventory;
import Inventory.Projections.InventoryI;

import Inventory.Projections.InventoryI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

//    @Query("SELECT a.name from inventory a")
//    List<Inventory> findNames();
    @Query("SELECT e from Inventory e")
    List<InventoryI> findNames();
}
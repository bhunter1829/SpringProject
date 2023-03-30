package Inventory.Repository;

import Inventory.Model.Inventory;
import Inventory.Projections.InventoryI;
import Inventory.Model.Department;

import Inventory.Projections.InventoryI;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

//    @Query("SELECT a.name from inventory a")
//    List<Inventory> findNames();

@Modifying
@Transactional // <- document
@Query("delete from Inventory where UPPER(name) = :name")
void deleteByName(@PathParam("name") String name);

    @Query("SELECT e from Inventory e")
    List<InventoryI> findNames();

    List<Inventory> findAll();
    @Query("SELECT SUM(i.amount) FROM Inventory i")
    int sum();
//    @Query("SELECT COUNT (inventory_id) FROM Inventory")
//    Inventory findCount();

//    @Query("SELECT name FROM Inventory where UPPER(name)=:name")
//    List <Inventory> findAllByName(String name);
}

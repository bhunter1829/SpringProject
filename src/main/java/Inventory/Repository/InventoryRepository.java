package Inventory.Repository;

import Inventory.Model.Inventory;
import Inventory.Projections.InventoryI;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    //query to delete inventory based on name
    @Modifying
    @Transactional // <- document
    @Query("delete from Inventory where UPPER(name) = :name")
    void deleteByName(@PathParam("name") String name);

    //retrieve just names instead of everything. Uses a projection for partial view, grabbing the properties we care about.
    @Query("SELECT e from Inventory e")
    List<InventoryI> findNames();

    Inventory save(Inventory inventory);
    List<Inventory> findAll();

    //retrieve the sum of all "amount" values
    @Query("SELECT SUM(i.amount) FROM Inventory i")
    int sum();


    List<Inventory> findAllByName(String name);

    //update the amount
    @Modifying
    @Transactional
    @Query("UPDATE Inventory i SET i.amount = :amount WHERE i.name = :name")
    void updateAmount(@PathParam("name") String name, @PathParam("amount") int amount);

}

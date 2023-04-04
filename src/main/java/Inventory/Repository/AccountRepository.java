package Inventory.Repository;

import Inventory.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{


    Account findUserByUsername(String username);
}

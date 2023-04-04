package Inventory.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

    //Contains Account data
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    //    should probably be an enum






    //    every time a user logs in, we should update their secureToken, so that any attempt to modify the user's
//    sensitive data requires the frontend to also have the token (fake JWT)
    private long secureToken;

}

package Inventory.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


        //Contains Inventory data
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "inventory")
public class Inventory {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "inventory_id")
        public Long id;
        @Column(name = "name")
        public String name;

        @Column(name = "amount")
        public int amount;

        public Long departmentFK;

        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "departmentFK", insertable = false, updatable = false)
        public Department department;


}


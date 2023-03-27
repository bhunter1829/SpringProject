package Inventory.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;



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


        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "departmentFK")
        public Department department;

        public String getName(){
           return name;
        }
}


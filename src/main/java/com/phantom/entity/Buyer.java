package com.phantom.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "Buyer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "inBaseBuyer",query = "SELECT b FROM Buyer b WHERE b.name = : buyerName")
})
public class Buyer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Buyer(String name) {
        this.name = name;
    }
}

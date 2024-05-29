package br.com.rappidu.infra.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "ADDRESSES")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STREET", length = 100)
    private String street;

    @Column(name = "NEIGHBORHOOD",length = 50)
    private String neighborhood;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "STATE", length = 20)
    private String state;

    @Column(name = "ZIPCODE", length = 8)
    private String zipcode;

    @ManyToOne
    private CustomerEntity customer;

}

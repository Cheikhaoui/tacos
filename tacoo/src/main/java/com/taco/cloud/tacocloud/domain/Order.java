package com.taco.cloud.tacocloud.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "taco_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Date placedAt;
    @ManyToMany(targetEntity = Taco.class)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Taco> tacos;
    @ManyToOne
    private User user;

    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }
}

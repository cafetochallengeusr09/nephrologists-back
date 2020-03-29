package com.cafeto.challenge.city.model;

import com.cafeto.challenge.zone.model.Zone;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    @NonNull
    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    @NonNull
    private Zone zone;
}

package com.challenge.clinic.model;

import com.challenge.city.model.City;
import com.challenge.clinicType.model.ClinicType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "clinic")
@Data
@NoArgsConstructor
public class Clinic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "administrator")
    @NonNull
    private String administrator;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "director")
    @NonNull
    private String director;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @NonNull
    private City city;

    @Column(name = "capacity")
    @NonNull
    private Long capacity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clinic_type_id", referencedColumnName = "id")
    @NonNull
    private ClinicType clinicType;

}

package com.cafeto.challenge.nephrologist.model;

import com.cafeto.challenge.nephrologistType.model.NephrologistType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "nephrologist")
@Data
@NoArgsConstructor
public class Nephrologist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nephrologist_type_id", referencedColumnName = "id")
    @NonNull
    private NephrologistType nephrologistType;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "active")
    @NonNull
    private Boolean active;

}

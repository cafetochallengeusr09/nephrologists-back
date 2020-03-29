package com.cafeto.challenge.nephrologistBaseClinic.model;

import com.cafeto.challenge.clinic.model.Clinic;
import com.cafeto.challenge.nephrologist.model.Nephrologist;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "nephrologist_base_clinic")
@Data
@NoArgsConstructor
public class NephrologistBaseClinic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nephrologist_id", referencedColumnName = "id")
    @NonNull
    private Nephrologist nephrologist;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    @NonNull
    private Clinic clinic;

    @Column(name = "salary")
    @NonNull
    private BigDecimal salary;

    @Column(name = "dedication_hours")
    @NonNull
    private Double dedicationHours;
}

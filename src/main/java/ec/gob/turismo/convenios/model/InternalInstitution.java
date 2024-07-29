package ec.gob.turismo.convenios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "internal_institutions")
public class InternalInstitution {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    //@UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "position_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_POSITION"))
    private Catalogue position;

    @ManyToOne
    @JoinColumn(name = "unit_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_UNIT"))
    private Catalogue unit;

    @ManyToOne
    @JoinColumn(name = "person_type_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_PERSON_TYPE"))
    private Catalogue personType;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT"))
    private Agreement agreement;

    @OneToMany(mappedBy = "modelId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstitutionObligation> institutionObligations;

    @OneToMany(mappedBy = "modelId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Financing> financings;
}

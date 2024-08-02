package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "internal_institutions")
public class InternalInstitution {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_type_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_PERSON_TYPE"))
    private Catalogue personType;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT"))
    private Agreement agreement;

    @OneToMany(mappedBy = "internalInstitution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InternalInstitutionDetail> internalInstitutionDetails;

}

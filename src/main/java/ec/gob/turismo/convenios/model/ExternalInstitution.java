package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "external_institutions")
public class ExternalInstitution {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT_EXTERNAL_INSTITUTION"))
    private Agreement agreement;

    @ManyToOne
    @JoinColumn(name = "person_type_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_EXTERNAL_INSTITUTION"))
    private Catalogue personType;

    @OneToMany(mappedBy = "externalInstitution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExternalInstitutionDetail> externalInstitutionDetails;
}

package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "external_institution_details")
public class ExternalInstitutionDetail {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String unit;

    @ManyToOne
    @JoinColumn(name = "external_institution_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT"))
    private ExternalInstitution externalInstitution;
}

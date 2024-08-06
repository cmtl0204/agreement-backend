package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "internal_institution_details")
public class InternalInstitutionDetail {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "position_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_POSITION"))
    private Catalogue position;

    @ManyToOne
    @JoinColumn(name = "unit_id",  foreignKey = @ForeignKey(name = "FK_CATALOGUE_UNIT"))
    private Catalogue unit;

    @ManyToOne
    @JoinColumn(name = "internal_institution_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT"))
    private InternalInstitution internalInstitution;

 }

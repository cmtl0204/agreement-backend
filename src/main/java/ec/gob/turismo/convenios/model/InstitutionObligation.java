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
@Table(name = "instituion_obligations")
public class InstitutionObligation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID model_id;

    @ManyToOne
    @JoinColumn(name = "obligation_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_OBLIGATION_TYPE_INSTITUTION_OBLIGATION"))
    private ObligationType obligationType;
}

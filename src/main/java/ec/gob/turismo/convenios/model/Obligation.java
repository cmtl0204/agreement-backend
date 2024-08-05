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
@Table(name = "obligations")
public class Obligation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String institutionName;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT"))
    private Agreement agreement;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_OBLIGATION_TYPE"))
    private Catalogue type;

    @OneToMany(mappedBy = "obligation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObligationDetail> obligationDetails;
}

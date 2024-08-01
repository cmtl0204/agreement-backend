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
@Table(name = "administrators")
public class Administrator {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean enable;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_UNIT_ADMINISTRATOR"))
    private Catalogue unit;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_POSITION_ADMINISTRATOR"))
    private Catalogue position;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT_ADMINISTRATOR"))
    private Agreement agreement;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ADMINISTRATOR"))
    private User user;

}

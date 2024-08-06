package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "agreement_states")
public class AgreementState {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AGREEMENT_AGREEMENT_STATE"))
    private Agreement agreement;

    @ManyToOne
    @JoinColumn(name = "state_id",  nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_AGREEMENT_STATE"))
    private Catalogue state;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_AGREEMENT_STATE"))
    private User user;
}

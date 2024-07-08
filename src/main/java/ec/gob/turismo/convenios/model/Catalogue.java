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
@Table(name = "catalogues")
public class Catalogue {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_CATALOGUE"))
    private Catalogue parent;

    @Column(length = 255, nullable = false)
    private String code;

    @Column(length = 255)
    private String description;

    @Column(length = 255, nullable = false)
    private String name;

    private Integer sort;

    @Column(length = 255, nullable = false)
    private String type;

    private boolean required;
}

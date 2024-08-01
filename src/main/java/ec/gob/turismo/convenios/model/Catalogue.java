package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

//@Data
@Getter
@Setter
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
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_CATALOGUE_CATALOGUE"))
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

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Catalogue> children;

}

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
@Table(name = "files")
public class File {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID modelId;

    @Column(length = 255)
    private String description;

    @Column(length = 255, nullable = false)
    private String extension;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String path;

    private double size;

    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "FK_CATALOGUE_FILE"))
    private Catalogue type;
}

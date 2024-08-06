package ec.gob.turismo.convenios.dto;

import ec.gob.turismo.convenios.model.Catalogue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MyFileDTO {

    @EqualsAndHashCode.Include
    private UUID id;

    private UUID modelId;

    private String description;

    private String extension;

    private String name;

    private String path;

    private double size;

    private boolean enabled;

    private Catalogue type;
}

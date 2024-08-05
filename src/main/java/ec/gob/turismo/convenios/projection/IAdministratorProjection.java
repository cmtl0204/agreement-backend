package ec.gob.turismo.convenios.projection;

import java.util.UUID;

public interface IAdministratorProjection {
    UUID getId();
    ICatalogueProjection getPosition();
    ICatalogueProjection getUnit();
}

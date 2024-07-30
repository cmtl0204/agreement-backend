package ec.gob.turismo.convenios.config;

import ec.gob.turismo.convenios.dto.AdministratorDTO;
import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.model.Administrator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

}

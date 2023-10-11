package br.com.josenaldo.catbasket.main;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.application.usecases.CreateCatInteractor;
import br.com.josenaldo.catbasket.infrastructure.controllers.CatDTOMapper;
import br.com.josenaldo.catbasket.infrastructure.gateways.CatEntityMapper;
import br.com.josenaldo.catbasket.infrastructure.gateways.CatRepositoryGateway;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {

    @Bean
    CreateCatInteractor createUseCase(CatGateway catGateway) {
        return new CreateCatInteractor(catGateway);
    }

    @Bean
    CatGateway catGateway(CatRepository catRepository, CatEntityMapper catEntityMapper) {
        return new CatRepositoryGateway(catRepository, catEntityMapper);
    }

    @Bean
    CatEntityMapper catEntityMapper() {
        return new CatEntityMapper();
    }

    @Bean
    CatDTOMapper catDTOMapper() {
        return new CatDTOMapper();
    }

}


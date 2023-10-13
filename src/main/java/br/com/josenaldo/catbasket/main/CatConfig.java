package br.com.josenaldo.catbasket.main;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.application.usecases.CreateCatInteractor;
import br.com.josenaldo.catbasket.application.usecases.GetCatsInteractor;
import br.com.josenaldo.catbasket.infrastructure.controllers.CatDTOMapper;
import br.com.josenaldo.catbasket.infrastructure.controllers.util.SortParameterParser;
import br.com.josenaldo.catbasket.infrastructure.gateways.CatEntityMapper;
import br.com.josenaldo.catbasket.infrastructure.gateways.CatRepositoryGateway;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatRepository;
import br.com.josenaldo.catbasket.infrastructure.persistence.SortRequestToJpaSortMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {

    @Bean
    CreateCatInteractor createUseCase(CatGateway catGateway) {
        return new CreateCatInteractor(catGateway);
    }

    @Bean
    GetCatsInteractor getCatsUseCase(CatGateway catGateway) {
        return new GetCatsInteractor(catGateway);
    }

    @Bean
    CatGateway catGateway(CatRepository catRepository, CatEntityMapper catEntityMapper, SortRequestToJpaSortMapper sortRequestToJpaSortMapper) {
        return new CatRepositoryGateway(catRepository, catEntityMapper, sortRequestToJpaSortMapper);
    }

    @Bean
    CatEntityMapper catEntityMapper() {
        return new CatEntityMapper();
    }

    @Bean
    CatDTOMapper catDTOMapper() {
        return new CatDTOMapper();
    }

    @Bean
    SortRequestToJpaSortMapper sortRequestToJpaSortMapper() {
        return new SortRequestToJpaSortMapper();
    }
    @Bean
    SortParameterParser sortParameterParser() {
        return new SortParameterParser();
    }

}


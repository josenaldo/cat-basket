package br.com.josenaldo.catbasket.infrastructure.gateways;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatEntity;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatRepository;

public class CatRepositoryGateway  implements CatGateway {
    private final CatRepository catRepository;
    private CatEntityMapper catEntityMapper;

    public CatRepositoryGateway(CatRepository catRepository, CatEntityMapper catEntityMapper) {
        this.catRepository = catRepository;
        this.catEntityMapper = catEntityMapper;
    }

    @Override
    public Cat createCat(Cat catDomainObject) {
        
        CatEntity catEntity = catEntityMapper.toEntity(catDomainObject);
        CatEntity savedCat = catRepository.save(catEntity);
        return catEntityMapper.toDomainObject(savedCat);
    }
}

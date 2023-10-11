package br.com.josenaldo.catbasket.infrastructure.gateways;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatEntity;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatRepository;

import java.util.List;
import java.util.stream.Stream;

public class CatRepositoryGateway  implements CatGateway {
    private final CatRepository catRepository;
    final private CatEntityMapper catEntityMapper;

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

    @Override
    public List<Cat> getAllCats() {
        List<CatEntity> catEntities = catRepository.findAll();
        return catEntities.stream().map(catEntityMapper::toDomainObject).toList();
    }


}

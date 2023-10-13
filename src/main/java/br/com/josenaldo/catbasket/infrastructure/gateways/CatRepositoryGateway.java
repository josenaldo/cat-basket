package br.com.josenaldo.catbasket.infrastructure.gateways;

import br.com.josenaldo.catbasket.application.SortRequest;
import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatEntity;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatRepository;
import br.com.josenaldo.catbasket.infrastructure.persistence.SortRequestToJpaSortMapper;
import org.springframework.data.domain.Sort;

import java.util.List;

public class CatRepositoryGateway implements CatGateway {
    private final CatRepository catRepository;
    final private CatEntityMapper catEntityMapper;
    final SortRequestToJpaSortMapper sortRequestToJpaSortMapper;

    public CatRepositoryGateway(CatRepository catRepository, CatEntityMapper catEntityMapper, SortRequestToJpaSortMapper sortRequestToJpaSortMapper) {
        this.catRepository = catRepository;
        this.catEntityMapper = catEntityMapper;
        this.sortRequestToJpaSortMapper = sortRequestToJpaSortMapper;
    }

    @Override
    public Cat createCat(Cat catDomainObject) {

        CatEntity catEntity = catEntityMapper.toEntity(catDomainObject);
        CatEntity savedCat = catRepository.save(catEntity);
        return catEntityMapper.toDomainObject(savedCat);
    }

    @Override
    public List<Cat> getAllCats(List<SortRequest> sortRequestList) {
        Sort sort = sortRequestToJpaSortMapper.mapToJpaSort(sortRequestList);

        List<CatEntity> catEntities = catRepository.findAll(sort);

        return catEntities.stream().map(catEntityMapper::toDomainObject).toList();
    }


}

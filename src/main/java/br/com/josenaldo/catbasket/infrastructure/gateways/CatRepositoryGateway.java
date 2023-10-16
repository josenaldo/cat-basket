package br.com.josenaldo.catbasket.infrastructure.gateways;

import br.com.josenaldo.catbasket.domain.application.SortRequest;
import br.com.josenaldo.catbasket.domain.application.gateways.CatGateway;
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
    public Cat createCat(Cat cat) {
        CatEntity catEntity = catEntityMapper.toEntity(cat);
        CatEntity savedCat = catRepository.save(catEntity);
        return catEntityMapper.toDomainObject(savedCat);
    }

    @Override
    public List<Cat> getCats(String byName, List<SortRequest> sortRequestList)  {

        Sort sort = sortRequestToJpaSortMapper.mapToJpaSort(sortRequestList);

        List<CatEntity> entityResults;

        if (byName != null && !byName.isBlank()) {
            String byNameParam = "%%%s%%".formatted(byName);
            entityResults = catRepository.findByNameLike(byNameParam, sort);
        }else {
            entityResults = catRepository.findAll(sort);
        }

        return entityResults.stream().map(catEntityMapper::toDomainObject).toList();
    }


}

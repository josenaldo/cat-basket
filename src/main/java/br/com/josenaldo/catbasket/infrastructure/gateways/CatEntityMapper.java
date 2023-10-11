package br.com.josenaldo.catbasket.infrastructure.gateways;

import br.com.josenaldo.catbasket.domain.entity.Cat;
import br.com.josenaldo.catbasket.infrastructure.persistence.CatEntity;

public class CatEntityMapper {

    CatEntity toEntity(Cat catDomainObject) {
        return new CatEntity(catDomainObject.name(), catDomainObject.sex(), catDomainObject.birthDate());
    }

    Cat toDomainObject(CatEntity catEntity) {
        return new Cat(catEntity.getId(), catEntity.getName(), catEntity.getSex(), catEntity.getBirthDate());
    }
}

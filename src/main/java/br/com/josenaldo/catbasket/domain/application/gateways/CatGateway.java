package br.com.josenaldo.catbasket.domain.application.gateways;

import br.com.josenaldo.catbasket.domain.application.SortRequest;
import br.com.josenaldo.catbasket.domain.entity.Cat;

import java.util.List;

public interface CatGateway {
    Cat createCat(Cat cat);

    List<Cat> getCats(String byName, List<SortRequest> sortRequestList) ;
}

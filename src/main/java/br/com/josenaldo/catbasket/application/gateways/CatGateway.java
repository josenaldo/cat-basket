package br.com.josenaldo.catbasket.application.gateways;

import br.com.josenaldo.catbasket.application.SortRequest;
import br.com.josenaldo.catbasket.domain.entity.Cat;

import java.util.List;

public interface CatGateway {
    Cat createCat(Cat cat);

    List<Cat> getAllCats(List<SortRequest> sortRequestList);
}

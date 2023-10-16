package br.com.josenaldo.catbasket.domain.application.usecases;

import br.com.josenaldo.catbasket.domain.application.SortRequest;
import br.com.josenaldo.catbasket.domain.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;

import java.util.List;

public class GetCatsInteractor {

    final private CatGateway catGateway;

    public GetCatsInteractor(CatGateway catGateway) {
        this.catGateway = catGateway;
    }

    public List<Cat> getCats(String byName, List<SortRequest> sortRequestList) {
        return catGateway.getCats(byName,sortRequestList);
    }
}

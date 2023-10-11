package br.com.josenaldo.catbasket.application.usecases;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;

import java.util.List;

public class GetCatsInteractor {

    final private CatGateway catGateway;

    public GetCatsInteractor(CatGateway catGateway) {
        this.catGateway = catGateway;
    }

    public List<Cat> getAllCats() {
        return catGateway.getAllCats();
    }
}

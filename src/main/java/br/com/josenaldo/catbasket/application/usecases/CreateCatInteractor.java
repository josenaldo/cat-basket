package br.com.josenaldo.catbasket.application.usecases;

import br.com.josenaldo.catbasket.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;

public class CreateCatInteractor {

    private CatGateway catGateway;

    public CreateCatInteractor(CatGateway catGateway) {
        this.catGateway = catGateway;
    }

    public Cat createCat(Cat cat) {
        return catGateway.createCat(cat);
    }
}

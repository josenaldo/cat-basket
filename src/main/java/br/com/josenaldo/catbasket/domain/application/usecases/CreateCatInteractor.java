package br.com.josenaldo.catbasket.domain.application.usecases;

import br.com.josenaldo.catbasket.domain.application.gateways.CatGateway;
import br.com.josenaldo.catbasket.domain.entity.Cat;

public class CreateCatInteractor {

    final private CatGateway catGateway;

    public CreateCatInteractor(CatGateway catGateway) {
        this.catGateway = catGateway;
    }

    public Cat createCat(Cat cat) {
        return catGateway.createCat(cat);
    }
}

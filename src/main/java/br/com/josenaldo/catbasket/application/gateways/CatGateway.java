package br.com.josenaldo.catbasket.application.gateways;

import br.com.josenaldo.catbasket.domain.entity.Cat;

public interface CatGateway {
    Cat createCat(Cat cat);
}

package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Cat;

public class CatDTOMapper {
    CreateCatResponse toResponse(Cat cat) {
        return new CreateCatResponse(cat.id(), cat.name(), cat.gender(), cat.birthDate());
    }

    public Cat toCat(CreateCatRequest request) {
        return new Cat(null, request.name(), request.gender(), request.birthDate());
    }
}

package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.application.usecases.CreateCatInteractor;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cats")
public class CatController {

    private CreateCatInteractor createCatInteractor;
    private CatDTOMapper catDTOMapper;

    public CatController(CreateCatInteractor createCatInteractor, CatDTOMapper catDTOMapper) {
        this.createCatInteractor = createCatInteractor;
        this.catDTOMapper = catDTOMapper;
    }

    @PostMapping
    public CreateCatResponse create(@RequestBody CreateCatRequest request) {
        Cat cat = catDTOMapper.toCat(request);
        Cat savedCat = createCatInteractor.createCat(cat);
        return catDTOMapper.toResponse(savedCat);
    }
}

package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.application.usecases.CreateCatInteractor;
import br.com.josenaldo.catbasket.application.usecases.GetCatsInteractor;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatController {

    final private CreateCatInteractor createCatInteractor;
    final private GetCatsInteractor getCatsInteractor;
    final private CatDTOMapper catDTOMapper;

    public CatController(CreateCatInteractor createCatInteractor, GetCatsInteractor getCatsInteractor, CatDTOMapper catDTOMapper) {
        this.createCatInteractor = createCatInteractor;
        this.getCatsInteractor = getCatsInteractor;
        this.catDTOMapper = catDTOMapper;
    }

    @PostMapping
    public CreateCatResponse create(@Valid @RequestBody CreateCatRequest request) {
        Cat cat = catDTOMapper.toCat(request);
        Cat savedCat = createCatInteractor.createCat(cat);
        return catDTOMapper.toResponse(savedCat);
    }

    @GetMapping
    public List<CreateCatResponse> getAll() {
        List<Cat> allCats = getCatsInteractor.getAllCats();

        return allCats.stream().map(catDTOMapper::toResponse).toList();
    }
}

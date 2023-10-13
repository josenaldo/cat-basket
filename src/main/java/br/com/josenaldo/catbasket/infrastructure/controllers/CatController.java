package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.application.SortRequest;
import br.com.josenaldo.catbasket.application.usecases.CreateCatInteractor;
import br.com.josenaldo.catbasket.application.usecases.GetCatsInteractor;
import br.com.josenaldo.catbasket.domain.entity.Cat;
import br.com.josenaldo.catbasket.infrastructure.controllers.util.SortParameterParser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatController {

    final private CreateCatInteractor createCatInteractor;
    final private GetCatsInteractor getCatsInteractor;
    final private CatDTOMapper catDTOMapper;

    final private SortParameterParser sortParameterParser;

    public CatController(CreateCatInteractor createCatInteractor, GetCatsInteractor getCatsInteractor, CatDTOMapper catDTOMapper, SortParameterParser sortParameterParser) {
        this.createCatInteractor = createCatInteractor;
        this.getCatsInteractor = getCatsInteractor;
        this.catDTOMapper = catDTOMapper;
        this.sortParameterParser = sortParameterParser;

    }

    @PostMapping
    public CreateCatResponse createCat(@Valid @RequestBody CreateCatRequest request) {
        Cat cat = catDTOMapper.toCat(request);
        Cat savedCat = createCatInteractor.createCat(cat);
        return catDTOMapper.toResponse(savedCat);
    }

    /**
     * Retrieves a list of all cats, with optional sorting.
     * <p>
     * This endpoint allows you to retrieve a list of all cats with an optional sorting parameter.
     * The `sort` parameter should be provided in the following format:
     * <p>
     * `sort=field1,direction1|field2,direction2|...`
     * <p>
     * - `field1`, `field2`, etc., represent the fields by which you want to sort the results.
     * - `direction1`, `direction2`, etc., represent the sort direction, which can be either "asc" (ascending) or "desc" (descending).
     * <p>
     * Example Usage:
     * To retrieve all cats sorted by "gender" in ascending order and then by "name" in ascending order, use the following URL:
     * <p>
     * `GET /cats?sort=gender,asc|name,asc`
     *
     * @param sortParameters The sorting parameter in the specified format.
     * @return A list of cat entities sorted according to the provided criteria.
     */
    @GetMapping
    public List<CreateCatResponse> getAllCats(@RequestParam(name="sort", defaultValue = "name,ASC", required = false) String sortParameters) {
        List<SortRequest> sortRequests = sortParameterParser.parseSortParameter(sortParameters, List.of("name", "gender", "birthDate"));

        List<Cat> allCats = getCatsInteractor.getAllCats(sortRequests);

        return allCats.stream().map(catDTOMapper::toResponse).toList();
    }
}

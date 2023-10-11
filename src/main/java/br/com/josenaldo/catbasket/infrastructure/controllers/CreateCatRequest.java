package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record CreateCatRequest(String name, Sex sex, @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate ) {
}

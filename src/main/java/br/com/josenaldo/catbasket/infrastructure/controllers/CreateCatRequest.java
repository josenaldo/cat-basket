package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CreateCatRequest(String name, Gender gender, @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate ) {
}

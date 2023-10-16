package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record CatResponse(UUID id, String name, Gender gender, LocalDate birthDate) {
}

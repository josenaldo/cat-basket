package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Sex;

import java.time.LocalDate;

public record CreateCatResponse(String name, Sex sex, LocalDate birthDate) {
}

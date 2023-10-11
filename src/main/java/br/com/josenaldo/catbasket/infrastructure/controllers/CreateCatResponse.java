package br.com.josenaldo.catbasket.infrastructure.controllers;

import br.com.josenaldo.catbasket.domain.entity.Gender;

import java.time.LocalDate;

public record CreateCatResponse(String name, Gender gender, LocalDate birthDate) {
}

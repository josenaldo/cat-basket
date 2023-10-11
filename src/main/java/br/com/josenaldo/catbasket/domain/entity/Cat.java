package br.com.josenaldo.catbasket.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

public record Cat(UUID id, String name, Gender gender, LocalDate birthDate ) { }

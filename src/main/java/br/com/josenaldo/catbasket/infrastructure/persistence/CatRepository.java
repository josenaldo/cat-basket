package br.com.josenaldo.catbasket.infrastructure.persistence;

import br.com.josenaldo.catbasket.domain.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatRepository extends JpaRepository<CatEntity, UUID> {
}

package br.com.josenaldo.catbasket.infrastructure.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatRepository extends JpaRepository<CatEntity, UUID> {
    List<CatEntity> findByNameLike(String name, Sort sort);
}

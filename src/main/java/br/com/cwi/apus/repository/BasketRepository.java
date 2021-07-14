package br.com.cwi.apus.repository;

import br.com.cwi.apus.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}

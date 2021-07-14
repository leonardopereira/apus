package br.com.cwi.apus.repository;

import br.com.cwi.apus.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

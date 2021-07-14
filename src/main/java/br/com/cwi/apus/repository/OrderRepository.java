package br.com.cwi.apus.repository;

import br.com.cwi.apus.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

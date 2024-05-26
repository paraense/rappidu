package br.com.rappidu.infra.repositories;

import br.com.rappidu.infra.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

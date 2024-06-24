package br.com.rappidu.infra.repositories;

import br.com.rappidu.infra.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByType(Integer productType);

}

package br.com.rappidu.infra.repositories;

import br.com.rappidu.infra.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustromerRepository extends JpaRepository<CustomerEntity, Long>  {
    Optional<CustomerEntity> findByCpf(String cpf);
}

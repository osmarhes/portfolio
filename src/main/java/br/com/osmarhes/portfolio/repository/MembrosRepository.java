package br.com.osmarhes.portfolio.repository;

import br.com.osmarhes.portfolio.model.Membros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, Long> {

}
package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Integer> {
}

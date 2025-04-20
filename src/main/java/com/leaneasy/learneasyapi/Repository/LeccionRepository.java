package com.leaneasy.learneasyapi.Repository;

import com.leaneasy.learneasyapi.Model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeccionRepository extends JpaRepository<Leccion, Integer> {
}

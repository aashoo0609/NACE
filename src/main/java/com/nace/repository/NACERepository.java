package com.nace.repository;

import com.nace.model.NACEDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NACERepository extends JpaRepository<NACEDto, Long> {
}

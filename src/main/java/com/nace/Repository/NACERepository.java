package com.nace.Repository;

import com.nace.Model.NACEDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NACERepository extends JpaRepository<NACEDto, Long> {
}

package com.test.java.hacken.domain.repository;

import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericCSVFileRepository extends JpaRepository<GenericCSVFileEntity, Long> {
}

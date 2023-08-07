package com.practice.repository;

import com.practice.entity.WikimediaData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}

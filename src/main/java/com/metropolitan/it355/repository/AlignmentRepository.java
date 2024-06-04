package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Alignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlignmentRepository extends JpaRepository<Alignment, Integer> {
    List<Alignment> findByTitle(String title);

    @Query(value = "SELECT * FROM `alignment` WHERE alignment.alignment LIKE :title" , nativeQuery = true)
    List<Alignment> findByTitleContaining(String title);
}

package com.faydan.novel.repository;

import com.faydan.novel.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassifyRepository extends JpaRepository<Classify, Integer> {
    Optional<Classify> findById(Integer id);

    List<Classify> findByLevel(Integer level);
}

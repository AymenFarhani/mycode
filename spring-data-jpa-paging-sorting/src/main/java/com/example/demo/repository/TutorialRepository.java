package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	Page<Tutorial> findByPublished(boolean published, Pageable pageable);

	Page<Tutorial> findByTitleContaining(String title, Pageable pageable);

	List<Tutorial> findByTitleContaining(String title, Sort sort);
}

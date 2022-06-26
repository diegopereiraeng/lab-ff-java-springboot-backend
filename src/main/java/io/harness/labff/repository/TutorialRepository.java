package io.harness.labff.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.harness.labff.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
  List<Tutorial> findByPublished(boolean published);
  List<Tutorial> findByTitleContaining(String title);
}

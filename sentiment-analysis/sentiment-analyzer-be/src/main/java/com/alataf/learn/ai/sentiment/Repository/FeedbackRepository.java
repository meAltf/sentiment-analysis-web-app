package com.alataf.learn.ai.sentiment.Repository;

import com.alataf.learn.ai.sentiment.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
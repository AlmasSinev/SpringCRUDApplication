package ru.plassrever.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.plassrever.demo.model.TrackMood;

public interface TrackMoodRepository extends JpaRepository<TrackMood, Integer> {
}

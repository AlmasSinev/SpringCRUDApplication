package ru.plassrever.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plassrever.demo.model.TrackMood;
import ru.plassrever.demo.repository.TrackMoodRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class TrackMoodService {

    private final TrackMoodRepository repository;

    public TrackMoodService(TrackMoodRepository repository) {
        this.repository = repository;
    }

    public TrackMood findById(int id){
        return repository.getOne(id);
    }

    public TrackMood findByName(String name){
        TrackMood trackMood = new TrackMood();
        trackMood.setId(-1);
        List<TrackMood> moods = findAll();

        for (TrackMood mood : moods){
            if (mood.getName() == name){
                trackMood = mood;
            }
        }

        return trackMood;
    }

    public List<TrackMood> findAll() {
        return repository.findAll();
    }

    public TrackMood saveMood(TrackMood mood){
        return repository.save(mood);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

}

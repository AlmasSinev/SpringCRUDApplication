package ru.plassrever.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.plassrever.demo.model.TrackMood;
import ru.plassrever.demo.service.TrackMoodService;


import java.util.List;


@Controller
public class MoodController {

    private final TrackMoodService moodService;

    public MoodController(TrackMoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/moods")
    public String findAll(Model model){
        List<TrackMood> moods = moodService.findAll();
        model.addAttribute("moods", moods);
        return "mood-list";
    }

    @GetMapping("/mood-create")
    public String createMoodForm(TrackMood mood){
        return "mood-create";
    }

    @PostMapping("/mood-create")
    public String createMood(TrackMood mood){
        moodService.saveMood(mood);
        return "redirect:/moods";
    }

    @ModelAttribute(value = "mood")
    public TrackMood newMood()
    {
        return new TrackMood();
    }

    @GetMapping("/mood-get-by-name")
    public String getByname(@RequestParam String name, Model model){
        model.addAttribute( "mood", moodService.findByName(name));
        return "mood-get-by-name";
    }

    @GetMapping("mood-delete/{id}")
    public String deleteMood(@PathVariable("id") int id){
        moodService.deleteById(id);
        return "redirect:/moods";
    }

    @GetMapping("/mood-update/{id}")
    public String updateMoodForm(@PathVariable("id") int id, Model model){
        TrackMood mood = moodService.findById(id);
        model.addAttribute("mood", mood);
        return "/mood-update";
    }

    @PostMapping("/mood-update")
    public String updateMood(TrackMood mood){
        moodService.saveMood(mood);
        return "redirect:/moods";
    }
}

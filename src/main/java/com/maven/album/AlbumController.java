package com.maven.album;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlbumController {

    // ROOT → HOME
    @GetMapping("/")
    public String root(Model model) {
        return "home";
    }

    // EXPLICIT /home (keeps your existing link working)
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    // SONG LIST PAGE
    @GetMapping("/songs")
    public String songs(Model model) {
        return "songs";
    }

    // META PAGE
    @GetMapping("/meta")
    public String meta(Model model) {
        return "meta";
    }

    // SHUFFLE PAGE
    @GetMapping("/shuffle")
    public String shuffle(Model model) {
        return "shuffle";
    }

    // NEW: SONG DETAIL PAGE /song/{id}
    @GetMapping("/song/{id}")
    public String song(@PathVariable Long id, Model model) {
        // minimal placeholder so template has something:
        model.addAttribute("songId", id);
        return "song";  // uses src/main/resources/templates/song.html
    }
}


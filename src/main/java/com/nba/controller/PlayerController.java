package com.nba.controller;

import com.nba.entity.Player;
import com.nba.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}

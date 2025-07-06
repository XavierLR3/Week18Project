package com.nba.service;

import com.nba.entity.Player;
import com.nba.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Integer id, Player playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setName(playerDetails.getName());
        player.setPosition(playerDetails.getPosition());
        player.setTeam(playerDetails.getTeam());
        player.setSkills(playerDetails.getSkills());
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}

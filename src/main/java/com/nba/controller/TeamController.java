package com.nba.controller;

import com.nba.entity.Team;
import com.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }
}

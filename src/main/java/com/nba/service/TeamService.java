package com.nba.service;

import com.nba.entity.Team;
import com.nba.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Integer id, Team teamDetails) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.setName(teamDetails.getName());
        return teamRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}

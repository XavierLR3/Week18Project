package com.nba.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    @ManyToMany
    @JoinTable(
        name = "player_skills",
        joinColumns = @JoinColumn(name = "player_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonManagedReference // ✅ Add this to prevent recursion
    private Set<Skill> skills;

    public Player() {}

    public Player(Integer id, String name, String position, Team team, Set<Skill> skills) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team = team;
        this.skills = skills;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}

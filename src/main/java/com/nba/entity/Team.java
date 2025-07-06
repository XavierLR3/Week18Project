package com.nba.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonManagedReference // 👈 Prevents recursion
    private Set<Player> players;

    // No-args constructor
    public Team() {
    }

    // All-args constructor
    public Team(Integer id, String name, Set<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    // Getters and setters

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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}

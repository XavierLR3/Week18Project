package com.nba.controller;

import com.nba.entity.Skill;
import com.nba.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Optional<Skill> getSkillById(@PathVariable Integer id) {
        return skillService.getSkillById(id);
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Integer id, @RequestBody Skill skill) {
        return skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Integer id) {
        skillService.deleteSkill(id);
    }
}

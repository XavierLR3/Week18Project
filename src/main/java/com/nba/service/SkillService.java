package com.nba.service;

import com.nba.entity.Skill;
import com.nba.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Integer id) {
        return skillRepository.findById(id);
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Integer id, Skill skillDetails) {
        Skill skill = skillRepository.findById(id).orElseThrow();
        skill.setName(skillDetails.getName());
        return skillRepository.save(skill);
    }

    public void deleteSkill(Integer id) {
        skillRepository.deleteById(id);
    }
}

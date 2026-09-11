package com.stency.personal_portfolio.controller;

import com.stency.personal_portfolio.entity.SkillEntity;
import com.stency.personal_portfolio.repository.SkillRepository;
import com.stency.personal_portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private final SkillService skillService;

    @Autowired
//constructo
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<SkillEntity>getAllSkills(){
        return skillService.getAllSkills();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SkillEntity>getSkillById(@PathVariable Long id){
        return skillService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public  SkillEntity createSkill(@RequestBody SkillEntity skill){
        return skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public SkillEntity updateSkill(@PathVariable Long id, @RequestBody SkillEntity skill) {
        return skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }





}

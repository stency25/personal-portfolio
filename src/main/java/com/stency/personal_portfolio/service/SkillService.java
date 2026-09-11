package com.stency.personal_portfolio.service;

import com.stency.personal_portfolio.entity.SkillEntity;
import com.stency.personal_portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    //constructor injection
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    /// get all skills method//this is what gets called when someone visits /api/skills — it says give me every skill in the database."
public List<SkillEntity>getAllSkills(){
    return skillRepository.findAll();
}
//gets skills by id method
public java.util.Optional<SkillEntity>getById(Long id){
    return skillRepository.findById(id);
}
//method 3
    public SkillEntity createSkill(SkillEntity skill) {
    return skillRepository.save(skill);
    }
    //update skill method
public SkillEntity updateSkill(Long id,SkillEntity updateSkill){
    return skillRepository.findById(id)
            .map(existing -> {
        existing.setName(updateSkill.getName());
        existing.setCategory(updateSkill.getCategory());
                return skillRepository.save(existing);
    }  )
    .orElseThrow(() -> new RuntimeException("skills not found" + id));
}
//delete metho by id
    public void deleteSkill (Long id){
    skillRepository.deleteById(id);
    }

}

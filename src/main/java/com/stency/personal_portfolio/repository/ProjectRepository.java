package com.stency.personal_portfolio.repository;

import com.stency.personal_portfolio.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository <ProjectEntity , Long>{

}

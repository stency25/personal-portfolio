package com.stency.personal_portfolio.repository;

import com.stency.personal_portfolio.entity.ContactMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessageEntity, Long> {
}

package com.stency.personal_portfolio.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name= "contact_message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;

    @Column(length = 2000)
    private String message;

    private LocalDateTime submittedAt;
}

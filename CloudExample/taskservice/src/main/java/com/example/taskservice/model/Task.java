package com.example.taskservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "create_time")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createTime = LocalDateTime.now();;
}

package com.hardsoftday.SpringBoot.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = new Date();
        if (createdDate == null) {
            createdDate = new Date();
        }
    }
}

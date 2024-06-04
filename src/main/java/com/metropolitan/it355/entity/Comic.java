package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "comic_name", length = 200)
    private String comicName;

    @Column(name = "issue")
    private Integer issue;

    @Column(name = "publish_month")
    private Integer publishMonth;

    @Column(name = "publish_year")
    private Integer publishYear;

}
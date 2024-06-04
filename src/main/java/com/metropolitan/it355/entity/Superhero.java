package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "superhero")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "superhero_name", length = 200)
    private String superheroName;

    @Column(name = "full_name", length = 200)
    private String fullName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eye_colour_id")
    private Colour eyeColour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hair_colour_id")
    private Colour hairColour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skin_colour_id")
    private Colour skinColour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alignment_id")
    private Alignment alignment;

    @Column(name = "height_cm")
    private Integer heightCm;

    @Column(name = "weight_kg")
    private Integer weightKg;

}
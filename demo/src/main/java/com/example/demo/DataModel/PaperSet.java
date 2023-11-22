package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "paper_sets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaperSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;


}

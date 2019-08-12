package com.acc.test.hibernate.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private Integer points;

//    @ManyToMany(mappedBy = "achievements")
//    private Set<User> users = new HashSet<>();

}

package com.acc.test.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Reservation> reservations = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_achievements", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private Set<Achievement> achievements = new HashSet<>();

    public void addReservation(Reservation reservationItem){
        this.reservations.add(reservationItem);
        reservationItem.setUser(this);
    }


    public void addAchievement(Achievement a) {
        this.achievements.add(a);
       // a.getUsers().add(this);
    }
//
//    public void removeAchievement(Achievement a) {
//        this.achievements.remove(a);
//        a.getUsers().remove(this);
//    }

}

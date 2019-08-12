package com.acc.test.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "location")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Game> games = new HashSet<>();

    public void addReservation(Reservation reservationItem){
        this.reservations.add(reservationItem);
        reservationItem.setRoom(this);
    }

    public void addGame(Game gameItem){
        this.games.add(gameItem);
        gameItem.setRoom(this);
    }
}

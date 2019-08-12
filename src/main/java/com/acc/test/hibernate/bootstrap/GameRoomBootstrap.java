package com.acc.test.hibernate.bootstrap;

import com.acc.test.hibernate.model.*;
import com.acc.test.hibernate.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

@Component
public class GameRoomBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AchievementRepository achievementRepository;
    private final GameRepository gameRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public GameRoomBootstrap(AchievementRepository achievementRepository, GameRepository gameRepository,
                             ReservationRepository reservationRepository, RoomRepository roomRepository, UserRepository userRepository) {
        this.achievementRepository = achievementRepository;
        this.gameRepository = gameRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        /*CREATING GAMES*/
        ArrayList<Game> games = new ArrayList<>();

        Game mortal = Game.builder()
                .name("Mortal Combat")
                .reservations(new HashSet<>()).build();
        games.add(mortal);

        Game tableFootball = Game.builder()
                .name("Table Football")
                .reservations(new HashSet<>()).build();
        games.add(tableFootball);

        Game darts = Game.builder()
                .name("Darts")
                .reservations(new HashSet<>()).build();
        games.add(darts);

        Game fifa = Game.builder()
                .name("Fifa")
                .reservations(new HashSet<>()).build();
        games.add(fifa);

        Game mario = Game.builder()
                .name("Super Mario")
                .reservations(new HashSet<>()).build();
        games.add(mario);

        Game basketball = Game.builder()
                .name("Basketball")
                .reservations(new HashSet<>()).build();
        games.add(basketball);

        Game tekken1 = Game.builder()
                .name("Tekken 3")
                .reservations(new HashSet<>()).build();
        games.add(tekken1);

        Game tekken2 = Game.builder()
                .name("Tekken 5")
                .reservations(new HashSet<>()).build();
        games.add(tekken2);

        Game nfs = Game.builder()
                .name("Need For Speed")
                .reservations(new HashSet<>()).build();
        games.add(nfs);

        Game vr = Game.builder()
                .name("VR")
                .reservations(new HashSet<>()).build();
        games.add(vr);


        /*CREATING ACHIEVEMENTS*/
        ArrayList<Achievement> achievements = new ArrayList<>();

        Achievement headhunter = Achievement.builder()
                .name("Headhunter")
                .points(30).build();
        achievements.add(headhunter);

        Achievement goldenBoots = Achievement.builder()
                .name("Golden Boots")
                .points(50).build();
        achievements.add(goldenBoots);

        Achievement ladderMaster = Achievement.builder()
                .name("Ladder Master")
                .points(100).build();
        achievements.add(ladderMaster);

        Achievement masterOfPuppets = Achievement.builder()
                .name("Master of Puppets")
                .points(15).build();
        achievements.add(masterOfPuppets);

        Achievement neverDie = Achievement.builder()
                .name("Never Die")
                .points(10).build();
        achievements.add(neverDie);

        Achievement longJumper = Achievement.builder()
                .name("Long Jumper")
                .points(10).build();
        achievements.add(longJumper);

        Achievement royal = Achievement.builder()
                .name("Royal")
                .points(150).build();
        achievements.add(royal);

        Achievement killer = Achievement.builder()
                .name("Killer")
                .points(45).build();
        achievements.add(killer);


        /*CREATING ROOMS*/
        ArrayList<Room> rooms = new ArrayList<>();

        Room gameRoomKatowice = Room.builder()
                .roomName("Game Room Katowice")
                .location("Katowice")
                .games(new HashSet<>())
                .reservations(new HashSet<>()).build();
        rooms.add(gameRoomKatowice);
        games.forEach(gameRoomKatowice::addGame);

        Room gameRoomLodz = Room.builder()
                .roomName("Game Room Lodz")
                .location("Lodz")
                .games(new HashSet<>())
                .reservations(new HashSet<>()).build();
        rooms.add(gameRoomLodz);

        for(int i = 0; i<5; i++){
            gameRoomLodz.addGame(games.get(i));
        }

        Room gameRoomKrakow = Room.builder()
                .roomName("Game Room Krakow")
                .location("Krakow")
                .games(new HashSet<>())
                .reservations(new HashSet<>()).build();
        rooms.add(gameRoomKrakow);
        games.forEach(gameRoomKrakow::addGame);

        Room gameRoomWarszawa = Room.builder()
                .roomName("Game Room Warszawa")
                .location("Warszawa")
                .games(new HashSet<>())
                .reservations(new HashSet<>()).build();
        rooms.add(gameRoomWarszawa);

        for(int i = 0; i<3; i++){
            gameRoomWarszawa.addGame(games.get(i));
        }


        /*CREATE USERS*/
        ArrayList<User> users = new ArrayList<>();
        User kasia = User.builder()
                .firstName("Kasia")
                .lastName("Urbaniec")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(kasia);
        achievements.forEach(kasia::addAchievement);

        User szymon = User.builder()
                .firstName("Szymon")
                .lastName("Szpakowski")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(szymon);
        for(int i=0; i<4;i++){
            szymon.addAchievement(achievements.get(i));
        }
        User jan = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(jan);
        for(int i=achievements.size()-1; i>5;i--){
            jan.addAchievement(achievements.get(i));
        }

        User marek = User.builder()
                .firstName("Marek")
                .lastName("Mostowiak")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(marek);
        for(int i=achievements.size()-1; i>3;i--){
            marek.addAchievement(achievements.get(i));
        }

        User krystian = User.builder()
                .firstName("Krystian")
                .lastName("Karczynski")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(krystian);
        achievements.forEach(krystian::addAchievement);

        User ian = User.builder()
                .firstName("Ian")
                .lastName("Curtis")
                .achievements(new HashSet<>())
                .reservations(new HashSet<>()).build();
        users.add(ian);
        for(int i=0; i<achievements.size()-3;i++){
            ian.addAchievement(achievements.get(i));
        }


        /*CREATE RESERVATIONS*/
        ArrayList<Reservation> reservations = new ArrayList<>();

        Reservation reservation1 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(1))
                .from(LocalDateTime.now().plusHours(1))
                .to(LocalDateTime.now().plusHours(2)).build();
        reservations.add(reservation1);

        Reservation reservation2 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(2))
                .from(LocalDateTime.now().plusHours(5))
                .to(LocalDateTime.now().plusHours(7)).build();
        reservations.add(reservation2);

        Reservation reservation3 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(10))
                .from(LocalDateTime.now().plusHours(10))
                .to(LocalDateTime.now().plusHours(12)).build();
        reservations.add(reservation3);

        Reservation reservation4 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(12))
                .from(LocalDateTime.now().plusHours(15))
                .to(LocalDateTime.now().plusHours(17)).build();
        reservations.add(reservation4);

        Reservation reservation5 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(3))
                .from(LocalDateTime.now().plusHours(1).plusDays(1))
                .to(LocalDateTime.now().plusHours(2).plusDays(1)).build();
        reservations.add(reservation5);

        Reservation reservation6 = Reservation.builder()
                .reservationTime(LocalDateTime.now().minusDays(14))
                .from(LocalDateTime.now().plusHours(5).plusMonths(1))
                .to(LocalDateTime.now().plusHours(7).plusMonths(1)).build();
        reservations.add(reservation6);


        for(int i = 0; i<reservations.size(); i++){
            games.get(i).addReservation(reservations.get(i));
        }

        gameRoomKatowice.addReservation(reservation1);
        gameRoomKatowice.addReservation(reservation5);
        gameRoomKatowice.addReservation(reservation6);
        gameRoomLodz.addReservation(reservation2);
        gameRoomLodz.addReservation(reservation3);
        gameRoomWarszawa.addReservation(reservation4);


        for(int i = 0; i<reservations.size(); i++){
            users.get(i).addReservation(reservations.get(i));
        }

        achievements.forEach(achievementRepository::save);

        reservations.forEach(reservationRepository::save);

        games.forEach(gameRepository::save);

        rooms.forEach(roomRepository::save);

        users.forEach(userRepository::save);

    }
}

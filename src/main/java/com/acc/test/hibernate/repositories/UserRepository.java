package com.acc.test.hibernate.repositories;

import com.acc.test.hibernate.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("select u.id, u.firstName, u.lastName, SUM(a.points) as sumpoints from User u join u.achievements a group by u.id having SUM(a.points) < ?1 and SUM(a.points) > ?2")
    List<Object[]> findAllByAchievementPoints(Long max, Long min, Sort sort);

    @Query("from User u join u.reservations res join res.room ro where ro.id = ?2 and upper(u.firstName) like upper(concat('%',?1,'%'))")
    List<User> findSpecificUserFromSpecificRoom(String s, Long roomId);
}

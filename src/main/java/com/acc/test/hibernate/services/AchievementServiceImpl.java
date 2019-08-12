package com.acc.test.hibernate.services;

import com.acc.test.hibernate.repositories.AchievementRepository;
import org.springframework.stereotype.Service;

@Service
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }
}

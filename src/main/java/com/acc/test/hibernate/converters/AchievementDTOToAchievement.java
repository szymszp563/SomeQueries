package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.AchievementDTO;
import com.acc.test.hibernate.model.Achievement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AchievementDTOToAchievement implements Converter<AchievementDTO, Achievement> {
    @Override
    public Achievement convert(AchievementDTO source) {
        if(source == null){
            return null;
        }

        final Achievement achievement = new Achievement();
        achievement.setId(source.getId());
        achievement.setName(source.getName());
        achievement.setPoints(source.getPoints());

        return achievement;
    }
}

package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.AchievementDTO;
import com.acc.test.hibernate.model.Achievement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AchievementToAchievementDTO implements Converter<Achievement, AchievementDTO> {

    @Override
    public AchievementDTO convert(Achievement source) {
        if(source == null){
            return null;
        }

        final AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(source.getId());
        achievementDTO.setName(source.getName());
        achievementDTO.setPoints(source.getPoints());

        return achievementDTO;
    }
}

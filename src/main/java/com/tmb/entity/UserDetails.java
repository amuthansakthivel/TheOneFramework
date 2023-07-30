package com.tmb.entity;

import com.tmb.entity.strategy.JobStrategy;
import lombok.Data;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
public class UserDetails {
    private String name;

    @PodamStrategyValue(JobStrategy.class)
    private String job;
}
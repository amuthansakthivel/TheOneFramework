package com.tmb.entity.requests;

import com.tmb.entity.strategy.FirstNameStrategy;
import com.tmb.entity.strategy.JobStrategy;
import lombok.Data;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
public class UserDetails {
    @PodamStrategyValue(FirstNameStrategy.class)
    private String name;

    @PodamStrategyValue(JobStrategy.class)
    private String job;
}
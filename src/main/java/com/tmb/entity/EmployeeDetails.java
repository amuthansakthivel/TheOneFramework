package com.tmb.entity;

import com.tmb.entity.strategy.FirstNameStrategy;
import com.tmb.entity.strategy.LastNameStrategy;
import lombok.Data;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
public class EmployeeDetails {

    @PodamStrategyValue(FirstNameStrategy.class)
    private String firstName;

    @PodamStrategyValue(LastNameStrategy.class)
    private String lastName;

    @PodamStrategyValue(LastNameStrategy.class)
    private String middleName;

    @PodamStringValue(strValue = "images/browserstack.jpeg")
    private String profilePicturePath;
}
package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Before;
import org.junit.Test;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS;
import static org.assertj.core.api.BDDAssertions.then;

public class UpperDeviationForShaftTest {

    private UpperDeviation upperDeviationForShaft;

    @Before
    public void setUp() {
        upperDeviationForShaft = new UpperDeviationForShaft();
    }

    @Test
    public void calculate_upper_deviation_should_be_4_when_add_3_to_1() {
        double calculatedUpperDeviation = upperDeviationForShaft.calculateUpperDeviation(3.0, 1.0);

        Double expectedValue = 4.0;
        then(calculatedUpperDeviation)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + calculatedUpperDeviation)
                .isEqualTo(expectedValue);
    }

    @Test
    public void calculate_upper_deviation_should_not_be_5_when_add_3_to_1() {
        double calculatedUpperDeviation = upperDeviationForShaft.calculateUpperDeviation(3.0, 1.0);

        Double notExpectedValue = 5.0;
        then(calculatedUpperDeviation)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + calculatedUpperDeviation)
                .isNotEqualTo(notExpectedValue);
    }
}
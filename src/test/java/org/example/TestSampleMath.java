package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSampleMath {

    @Test
    void testSum() {
        Assertions.assertEquals(2, SampleMath.sum(1,1));
        Assertions.assertNotEquals(2, SampleMath.sum(2,2));
    }
}

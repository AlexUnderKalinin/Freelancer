package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class FreelancerServiceTest {
    @Test
    public void testCalculate1() {
        FreelancerService service = new FreelancerService();
        int income = 10_000;
        int expences = 3_000;
        int threshold = 20_000;

        int actual = service.calculate(income, expences, threshold);
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCalculate2() {
        FreelancerService service = new FreelancerService();
        int income = 100_000;
        int expences = 60_000;
        int threshold = 150_000;

        int actual = service.calculate(income, expences, threshold);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "data_csv.csv")
    public void testCalculateWithParams(int income, int expences, int threshold, int expected) {
        FreelancerService service = new FreelancerService();

        int actual = service.calculate(income, expences, threshold);

        Assertions.assertEquals(expected, actual);
    }

}
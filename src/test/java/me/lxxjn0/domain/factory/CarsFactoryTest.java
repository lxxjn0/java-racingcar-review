package me.lxxjn0.domain.factory;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.lxxjn0.domain.car.Cars;

class CarsFactoryTest {

    @DisplayName("create() - 자동차 이름을 입력받아 Cars 객체 생성")
    @Test
    void create() {
        // given
        String inputCarNames = "test1,test2,test3";

        // then
        assertThat(CarsFactory.create(inputCarNames)).isInstanceOf(Cars.class);
    }
}

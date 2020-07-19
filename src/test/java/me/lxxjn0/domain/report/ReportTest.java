package me.lxxjn0.domain.report;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.lxxjn0.domain.car.Name;
import me.lxxjn0.domain.car.Position;

class ReportTest {
    @DisplayName("of() - 자동차의 위치와 이름을 입력받아 객체 생성")
    @Test
    void of() {
        // given
        Position position = new Position();
        Name name = new Name("test");

        // then
        assertThat(Report.of(name, position)).isInstanceOf(Report.class);
    }
}

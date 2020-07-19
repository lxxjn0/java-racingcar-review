package me.lxxjn0.domain.report;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

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

    @DisplayName("of() - 자동차의 이름이 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void of_NameIsNull(final Name name) {
        // given
        Position position = new Position();

        // then
        assertThatThrownBy(() -> Report.of(name, position))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("이름이 null입니다.");
    }

    @DisplayName("of() - 자동차의 위치가 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void of_PositionIsNull(final Position position) {
        // given
        Name name = new Name("test");

        // then
        assertThatThrownBy(() -> Report.of(name, position))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("위치가 null입니다.");
    }
}

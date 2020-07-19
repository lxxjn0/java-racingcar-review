package me.lxxjn0.domain.attemptnumber;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class AttemptNumberTest {

    @DisplayName("of() - 시도 횟수를 입력받아 객체 생성")
    @Test
    void of() {
        // given
        String inputAttemptNumber = "5";

        // then
        assertThat(AttemptNumber.of(inputAttemptNumber)).isInstanceOf(AttemptNumber.class);
    }

    @DisplayName("of() - 시도 횟수가 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void of_Exception(final String inputAttemptNumber) {
        // then
        assertThatThrownBy(() -> AttemptNumber.of(inputAttemptNumber))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("시도 횟수가 null입니다.");
    }

    @DisplayName("validate() - 최소 시도 횟수보다 작은 경우 예외 발생")
    @Test
    void validate() {
        // given
        String inputAttemptNumber = "0";

        // then
        assertThatThrownBy(() -> AttemptNumber.of(inputAttemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수가 1보다 작습니다.");
    }
}

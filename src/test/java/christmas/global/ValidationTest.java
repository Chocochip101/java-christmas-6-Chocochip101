package christmas.global;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {
    @Test
    @DisplayName("정수 변환에 성공한다.")
    public void testConvertInteger() {
        //given
        String input = "123";
        int output = 123;

        //when&then
        assertEquals(Validation.getInteger(input), output);
    }

    @DisplayName("정수가 아닌 수 입력 시, 예외가 발생한다.")
    @ValueSource(strings = {"1.1", " a", "1 2"})
    @ParameterizedTest
    public void testNotInteger(String input) {
        //given&when&then
        assertThatThrownBy(() -> Validation.getInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
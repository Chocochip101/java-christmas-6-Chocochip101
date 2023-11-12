package christmas.global;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateUtilTest {
    @Test
    @DisplayName("날짜 변환에 성공한다.")
    public void testConvertDate() {
        //given
        String userInput = "12";
        int expectedOutput = 12;

        //when&then
        assertEquals(DateUtil.convertInputToDate(userInput), expectedOutput);
    }

    @DisplayName("숫자 이외의 날짜 입력 시, 예외가 발생한다.")
    @ValueSource(strings = {" a", "1 2"})
    @ParameterizedTest
    public void testDateOutOfRange(String date) {
        //given&when&then
        assertThatThrownBy(() -> DateUtil.convertInputToDate(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
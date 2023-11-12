package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ScheduleTest {
    @Test
    @DisplayName("년, 월, 일로 일정을 생성할 수 있다.")
    public void testCreateSchedule() {
        //given
        int year = 2023;
        int month = 12;
        int day = 25;

        //when
        Schedule schedule = new Schedule(year, month, day);

        //then
        assertAll(
                () -> assertEquals(schedule.getYear(), year),
                () -> assertEquals(schedule.getMonth(), month),
                () -> assertEquals(schedule.getDay(), day)
        );
    }

    @DisplayName("날짜 범위 이외의 년 입력 시, 예외가 발생한다.")
    @ValueSource(ints = {999, 2025})
    @ParameterizedTest
    public void testYearOutOfRange(int year) {
        //given
        int month = 1;
        int day = 12;

        // when&then
        assertThatThrownBy(() -> new Schedule(year, month, day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 범위 이외의 월 입력 시, 예외가 발생한다.")
    @ValueSource(ints = {0, 13})
    @ParameterizedTest
    public void testMonthOutOfRange(int month) {
        //given
        int year = 2023;
        int day = 12;

        // when&then
        assertThatThrownBy(() -> new Schedule(year, month, day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 범위 이외의 일 입력 시, 예외가 발생한다.")
    @ValueSource(ints = {0, 32})
    @ParameterizedTest
    public void testDayOutOfRange(int day) {
        //given
        int year = 2023;
        int month = 12;

        // when&then
        assertThatThrownBy(() -> new Schedule(year, month, day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 년,월,일로 구성될 때, 동등하다.")
    public void testEquals() {
        //given
        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Schedule schedule1 = new Schedule(year, month, day);
        Schedule schedule2 = new Schedule(year, month, day);

        //then
        assertTrue(schedule1.equals(schedule2));
    }

    @Test
    @DisplayName("다른 년,월,일로 구성될 때, 동등하지 않다.")
    public void testDifferentEquals() {
        //given
        int year = 2023;
        int month = 12;
        int day1 = 12;
        int day2 = 13;

        //when
        Schedule schedule1 = new Schedule(year, month, day1);
        Schedule schedule2 = new Schedule(year, month, day2);

        //then
        assertFalse(schedule1.equals(schedule2));
    }
}
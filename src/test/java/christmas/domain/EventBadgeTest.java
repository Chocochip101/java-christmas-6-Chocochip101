package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeTest {

    @Test
    @DisplayName("이벤트 뱃지 생성에 성공한다.")
    public void createEventBadge() throws Exception {
        //given
        int noBadgePrice = 100;
        int starBadgePrice = 5_000;
        int treeBadgePrice = 10_000;
        int santaBadgePrice = 20_000;

        //when
        EventBadge noBadge = new EventBadge(noBadgePrice);
        EventBadge starBadge = new EventBadge(starBadgePrice);
        EventBadge treeBadge = new EventBadge(treeBadgePrice);
        EventBadge santaBadge = new EventBadge(santaBadgePrice);

        //then
        assertAll(
                () -> assertEquals(noBadge.getBadgeName(), "없음"),
                () -> assertEquals(starBadge.getBadgeName(), "별"),
                () -> assertEquals(treeBadge.getBadgeName(), "트리"),
                () -> assertEquals(santaBadge.getBadgeName(), "산타")
        );
    }
}
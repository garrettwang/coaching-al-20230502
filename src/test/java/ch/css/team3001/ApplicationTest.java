package ch.css.team3001;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void firstTest() {
        Application testee = new Application();
        boolean actual = testee.isTrue();
        assertThat(actual).isEqualTo(true);
    }
}
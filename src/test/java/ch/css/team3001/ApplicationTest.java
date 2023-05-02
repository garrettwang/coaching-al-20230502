package ch.css.team3001;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void firstTest() {
        List<?> actual;
        assertThat(true).isEqualTo(false);
    }
}
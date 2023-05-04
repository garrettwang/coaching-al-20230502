package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionTest {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assertions.assertThat(sum).isEqualTo(new Fraction(0));
    }

    @Test
    void NotZeroPlusZero() {
        Fraction sum = new Fraction(6).plus(new Fraction(0));
        Assertions.assertThat(sum).isEqualTo(new Fraction(6));
    }

    @Test
    void zeroPlusNotZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(9));
        Assertions.assertThat(sum).isEqualTo(new Fraction(9));
    }

    @Test
    void notZeroPlusNotZero() {
        Fraction sum = new Fraction(11).plus(new Fraction(8));
        Assertions.assertThat(sum).isEqualTo(new Fraction(19));
    }
    @Test
    void onefifthPlusThreefifth() {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(3,5));
        Assertions.assertThat(sum).isEqualTo(new Fraction(4,5));
    }

}

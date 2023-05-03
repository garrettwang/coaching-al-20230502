package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FractionsAddCalculatorTest {
    @Test
    void zeroPlusZeroIsZero() {
        FractionsAddCalculator testee = new FractionsAddCalculator();
        int actual = testee.calculate(0,0);
        Assertions.assertThat(actual).isEqualTo(0);
    }

    @Test
    void halfPlusHalfIsOne() {
        FractionsAddCalculator testee = new FractionsAddCalculator();
        int actual = testee.calculate(1,2,1,2);
        Assertions.assertThat(actual).isEqualTo(1);
    }

    @Test
    void onthirdPlusOnethirdIsTwothird() {
        FractionsAddCalculator testee = new FractionsAddCalculator();
        Fraction actual = testee.calculate2(1,3,1,3);
        Assertions.assertThat(actual).isEqualTo(new Fraction(2,3));
    }
}

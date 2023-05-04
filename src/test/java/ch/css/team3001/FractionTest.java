package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FractionTest {
    public static Stream<Arguments> integerFractionTestdataProvider() {
        return Stream.of(
                Arguments.of(new Fraction(0), new Fraction(0),new Fraction(0)),
                Arguments.of(new Fraction(6), new Fraction(0),new Fraction(6)),
                Arguments.of(new Fraction(0), new Fraction(9),new Fraction(9)),
                Arguments.of(new Fraction(11), new Fraction(8),new Fraction(19))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "integerFractionTestdataProvider")
    void notZeroPlusNotZero(Fraction firstFraction, Fraction secondFraction, Fraction expectedFraction) {
        Fraction sum = firstFraction.plus(secondFraction);
        Assertions.assertThat(sum).isEqualTo(expectedFraction);
    }

    @Test
    void onefifthPlusThreefifth() {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(3,5));
        Assertions.assertThat(sum).isEqualTo(new Fraction(4,5));
    }

    @Test
    void coprimeFractions() {
        Fraction sum = new Fraction(5, 7).plus(new Fraction(1,4));
        Assertions.assertThat(sum).isEqualTo(new Fraction(27,28));
    }

    @Test
    void zeroDenominator() {
        Assertions.assertThatThrownBy(() -> new Fraction(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

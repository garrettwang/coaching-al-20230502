package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(sum).isEqualTo(expectedFraction);
    }

    @Test
    void onefifthPlusThreefifth() {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(3,5));
        assertThat(sum).isEqualTo(new Fraction(4,5));
    }

    @Test
    void coprimeFractions() {
        Fraction sum = new Fraction(5, 7).plus(new Fraction(1,4));
        assertThat(sum).isEqualTo(new Fraction(27,28));
    }

    @Test
    void zeroDenominator() {
        Assertions.assertThatThrownBy(() -> new Fraction(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void negativeNumeratorAndPositveDenominator() {
        Fraction negativeFraction = new Fraction(-1, 1).plus(new Fraction(1,1));
        assertThat(negativeFraction).isEqualTo(new Fraction(0,1));
    }

    @Test
    void positiveNumeratorAndNegativeDenominator() {
        Fraction negativeFraction = new Fraction(1, -7).plus(new Fraction(1,8));
        assertThat(negativeFraction).isEqualTo(new Fraction(-1,56));
    }
}

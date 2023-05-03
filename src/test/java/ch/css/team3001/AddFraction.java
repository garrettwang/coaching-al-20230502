package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AddFraction {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assertions.assertThat(sum.intValue()).isEqualTo(0);
    }

    @Test
    void NotZeroPlusZero() {
        Fraction sum = new Fraction(6).plus(new Fraction(0));
        Assertions.assertThat(sum.intValue()).isEqualTo(6);
    }

    @Test
    void zeroPlusNotZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(9));
        Assertions.assertThat(sum.intValue()).isEqualTo(9);
    }

    @Test
    void notZeroPlusNotZero() {
        Fraction sum = new Fraction(11).plus(new Fraction(8));
        Assertions.assertThat(sum.intValue()).isEqualTo(19);
    }
    @Test
    void onefifthPlusThreefifth() {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(3,5));
        Assertions.assertThat(sum.numerator()).isEqualTo(4);
        Assertions.assertThat(sum.denominator()).isEqualTo(5);
    }

    private class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this.numerator = integerValue;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction that) {
            return new Fraction(this.numerator + that.numerator, that.denominator());
        }

        public int intValue() {
            return numerator;
        }

        public int numerator() {
            return this.numerator;
        }

        public int denominator() {
            return this.denominator;
        }
    }
}
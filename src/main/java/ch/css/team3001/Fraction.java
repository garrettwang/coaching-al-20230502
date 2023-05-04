package ch.css.team3001;

import java.util.Objects;

class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int integerValue) {
        this.numerator = integerValue;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction plus(Fraction that) {
        return new Fraction(this.numerator * that.denominator + this.denominator * that.numerator, this.denominator* that.denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction that = (Fraction) o;
        return numerator* that.denominator == that.numerator * denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "%d/%d".formatted(numerator,denominator);
    }
}

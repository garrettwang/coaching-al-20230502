package ch.css.team3001;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int integerValue) {
        this.numerator = integerValue;
        this.denominator = 1;
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

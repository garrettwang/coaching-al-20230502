package ch.css.team3001;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FractionInputTest {
    private final FractionParser fractionParser = new FractionParser();

    @Test
    void fractionWithSpace() {
        Fraction actual = fractionParser.takeInput(" 5 / 2 ");
        Assertions.assertThat(actual).isEqualTo(new Fraction(5,2));
    }

    @Test
    void fractionWithSpace3Over2() {
        Fraction actual = fractionParser.takeInput(" 3 / 2 ");
        Assertions.assertThat(actual).isEqualTo(new Fraction(3,2));
    }

    @Test
    void fractionWithSpace7Over4() {
        Fraction actual = fractionParser.takeInput(" 7 /    4 ");
        Assertions.assertThat(actual).isEqualTo(new Fraction(7,4));
    }

    public class FractionParser {
        public FractionParser() {
        }

        private Fraction takeInput(String fractionAsString) {
            String[] splitedString = fractionAsString.split("/");
            var numeratorString = splitedString[0];
            var denominatorString = splitedString[1];
            return new Fraction(Integer.parseInt(numeratorString.trim()), Integer.parseInt(denominatorString.trim()));
        }
    }
}

package ch.css.team3001;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SellOneItemTest {

    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<>() {{
            put("12345", "CAD 7.95");
            put("23456", "CAD 12.50");
        }});

        sale.onBarcode(new Barcode("12345"));

        assertThat(display.text()).isEqualTo("CAD 7.95");
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<>() {{
            put("12345", "CAD 7.95");
            put("23456", "CAD 12.50");
        }});
        sale.onBarcode(new Barcode("23456"));


        assertThat(display.text()).isEqualTo("CAD 12.50");
    }

    @Test
    void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, emptyMap());

        sale.onBarcode(new Barcode("9999"));

        assertThat(display.text()).isEqualTo("Product not found: 9999");
    }

    @Test
    void barcodeEmpty() {
        assertThatThrownBy(() -> new Barcode("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void barcodeIsNull() {
        assertThatThrownBy(() -> new Barcode(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void barcodeNotEmpty() {
        final Barcode actual = new Barcode("123");
        assertThat(actual.value()).isEqualTo("123");
    }

    private class Barcode {
        private final String value;

        public Barcode(final String value) {
            Objects.requireNonNull(value);
            if (value.isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.value = value;
        }

        public String value() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private static class Display {

        private String text;

        public String text() {
            return text;
        }

        public void setText(final String text) {
            this.text = text;
        }

    }

    private class Sale {
        final Map<String, String> pricesByBarcode;

        private final Display display;

        public Sale(final Display display, final Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
            this.display = display;
        }

        public void onBarcode(Barcode barcode) {

            display.setText(priceBy(barcode));
        }

        private String priceBy(Barcode barcode) {
            if (pricesByBarcode.containsKey(barcode.value())) {
                return pricesByBarcode.get(barcode.value());
            } else {
                return "Product not found: " + barcode;
            }
        }
    }

}

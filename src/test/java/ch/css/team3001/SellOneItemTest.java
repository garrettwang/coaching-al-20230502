package ch.css.team3001;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

        sale.onBarcode("12345");

        assertThat(display.text()).isEqualTo("CAD 7.95");
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<>() {{
            put("12345", "CAD 7.95");
            put("23456", "CAD 12.50");
        }});
        sale.onBarcode("23456");


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
    void emptyBarcode() {
        final Display display = new Display();
        final Sale sale = new Sale(display, null);

        sale.onBarcode("");

        assertThat(display.text()).isEqualTo("Scanning error: empty barcode");
    }

    @Test
    void barcodeEmpty() {
        assertThatThrownBy(() -> new Barcode("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void barcodeNotEmpty() {
        final Barcode actual = new Barcode("123");
        assertThat(actual.value()).isEqualTo("123");
    }

    private class Barcode {
        private final String value;

        public Barcode(final String value) {
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

        public void onBarcode(final String barcode) {
            if ("".equals(barcode)) {
                display.setText("Scanning error: empty barcode");
                return;
            }

            if (pricesByBarcode.containsKey(barcode)) {
                final String text = pricesByBarcode.get(barcode);
                display.setText(text);
            } else {
                display.setText("Product not found: " + barcode);
            }
        }

        public void onBarcode(Barcode barcode) {

            if (pricesByBarcode.containsKey(barcode.value())) {
                final String text = pricesByBarcode.get(barcode.value());
                display.setText(text);
            } else {
                display.setText("Product not found: " + barcode);
            }
        }
    }

}

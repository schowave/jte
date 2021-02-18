package gg.jte.benchmark;

import gg.jte.output.Utf8ByteOutput;
import org.junit.jupiter.api.Test;
import gg.jte.output.StringOutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Ensure that the benchmark page can be rendered without error
 */
public class BenchmarkTest {
    @Test
    void stringOutput() {
        StringOutput output = new Benchmark().render(new WelcomePage(42));

        assertThat(output.toString()).contains("This page has 42 visits already.");
    }

    @Test
    void binaryOutput() throws IOException {
        Utf8ByteOutput utf8ByteOutput = new Benchmark_Binary().render(new WelcomePage(42));

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        utf8ByteOutput.writeTo(os);
        assertThat(os.toString("UTF-8")).contains("This page has 42 visits already.");
    }
}

package org.example.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * test service that transforms xlsx to csv
 */
public class SheetToCsvTest {

    @Test
    void exampleFilePresent() {
        Assertions.assertNotNull(this.getClass().getResource("example.xlsx"));
        Assertions.assertNotNull(this.getClass().getResource("example.csv"));
    }

    @Test
    void whereWeRead(@TempDir Path tempDir) throws IOException {
        //given
        String sourceFilePath = Objects.requireNonNull(this.getClass().getResource("example.xlsx")).getFile();

        // when
        Path targetPath = tempDir.resolve("generated.csv");
        ToCsvTransformer.write(sourceFilePath, targetPath);

        // then
        List<String> generatedLines = Files.lines(targetPath).toList();
        List<String> expectedLines = List.of(
                "id,\"desc\",\"delta\",\"balance_after\"",
                "\"uidsiOd\",\"10350665209.PP/. Shop der Deutschen Post (DPDHL Group), Ihr Einkauf bei Shop der Deutschen Post (DPDHL Group) EREF: 1035060IBAN: LU8975 BIC: PPLXLUL2\",-0.85,152.61",
                "\"27cap0721\",\"REWE SAGT DANKE. 465/Muenchen 19.06.2024 um 17:18:06 Uhr 560PIN  REF 282\",-47.7,104.91",
                "\"7djaop\",\"income\",1200,1303.91"
        );
        assertThat(generatedLines, contains(expectedLines));

    }
}

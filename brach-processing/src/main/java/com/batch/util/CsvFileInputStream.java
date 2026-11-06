package com.batch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CsvFileInputStream {

	public static InputStream createInputStreamFromCsv(String csvFilePath) throws IOException {
        if (csvFilePath == null || csvFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException("CSV file path cannot be null or empty.");
        }

        File file = new File(csvFilePath);

        // Validate file existence and type
        if (!file.exists()) {
            throw new IOException("File does not exist: " + csvFilePath);
        }
        if (!file.isFile()) {
            throw new IOException("Path is not a file: " + csvFilePath);
        }
        if (!file.canRead()) {
            throw new IOException("File cannot be read: " + csvFilePath);
        }

        // Option 1: Using FileInputStream
        return new FileInputStream(file);

        // Option 2: Using NIO Files API (uncomment if preferred)
        // return Files.newInputStream(Path.of(csvFilePath));
    }

}

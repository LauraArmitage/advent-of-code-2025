package com.armitage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileReader {

    public static List<String> read(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        return Files.readAllLines(path);
    }
}

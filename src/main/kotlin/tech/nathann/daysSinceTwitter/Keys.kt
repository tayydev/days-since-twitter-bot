package tech.nathann.daysSinceTwitter

import java.nio.file.Files
import java.nio.file.Path

class Keys(path: String): List<String> by (Files.readAllLines(Path.of(path)).filter { it[0] != '#' })
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines().dropLastWhile { it.isEmpty() }

/**
 * Reads text from the given output txt file.
 */
fun readOutput(name: String) = File("src", "$name.txt").readText().trim()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun List<String>.toInts() = map { it.toInt() }

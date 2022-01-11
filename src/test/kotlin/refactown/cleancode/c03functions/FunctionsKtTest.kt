package refactown.cleancode.c03functions

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import refactown.cleancode.c06objects.Person
import refactown.cleancode.c07exceptions.JsonException
import refactown.cleancode.c07exceptions.fromJsonV1
import java.lang.IllegalArgumentException

internal class FunctionsKtTest {

    @Test
    fun testRockPaperScissors() {
        // DRAW = 0
        assertEquals(0, rockPaperScissors('R','R'))
        assertEquals(0, rockPaperScissors('P','P'))
        assertEquals(0, rockPaperScissors('S','S'))
        // Fisrt Wins = -1
        assertEquals(-1, rockPaperScissors('R','S'))
        assertEquals(-1, rockPaperScissors('S','P'))
        assertEquals(-1, rockPaperScissors('P','R'))
        // Second Wins = 1
        assertEquals(1, rockPaperScissors('S','R'))
        assertEquals(1, rockPaperScissors('P','S'))
        assertEquals(1, rockPaperScissors('R','P'))
        // Illegal Argument
        assertThrows(IllegalArgumentException::class.java) {
            rockPaperScissors('A', 'R')
        }
        assertThrows(IllegalArgumentException::class.java) {
            rockPaperScissors('S', '*')
        }
        assertThrows(IllegalArgumentException::class.java) {
            rockPaperScissors(' ', '%')
        }
    }
}
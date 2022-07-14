package tennis.kata.accelerate

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class GameTest {

    private val gameTest = Game(Player("Sonia"), Player("Pedro"))

    @Test
    fun `get the points won by player1(Sonia)`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        val totalPlayer1Points = gameTest.getPlayer1Points()
        assertThat(totalPlayer1Points).isEqualTo(3)
    }

    @Test
    fun `If at least three points have been scored by each player, and the scores are equal, the score is “deuce”`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Deuce")
    }

    @Test
    fun `advantage player 1`(){
        val player1Points = gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Advantage for Sonia")
    }
    @Test
    fun `win for player 2`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Win for Pedro")
    }
}
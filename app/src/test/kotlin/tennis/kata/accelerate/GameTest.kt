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

        val totalPlayer1Points = gameTest.player1Points
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
    fun `when previous score 40-40 and player one wins then current score is ADVANTADGE-40`(){
        val player1Points = gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Sonia")

        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Advantage for Sonia")
    }
    @Test
    fun `when previous score 40-ADVANTADGE and player two wins then Player 2 wins the GAME`(){
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
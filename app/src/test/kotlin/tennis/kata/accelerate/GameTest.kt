package tennis.kata.accelerate

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

internal class GameTest {

    private val gameTest = Game(Player("Sonia"), Player("Pedro"))

    @Test
    fun `initial score is Love-Love`(){

        assertThat(gameTest.getScore()).isEqualTo("Sonia: Love - Love :Pedro")
    }
    @Test
    fun `when previous score LOVE-LOVE and player one wins then current score is 15-LOVE`(){
        gameTest.wonPoint("Sonia")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: 15 - Love :Pedro")
    }

    @Test
    fun `when previous score 15-LOVE and player one wins then current score is 30-LOVE`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: 30 - Love :Pedro")
    }

    @Test
    fun `when previous score 30-LOVE and player one wins then current score is 40-LOVE`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: 40 - Love :Pedro")
    }

    @Test
    fun `when previous score LOVE-LOVE and player two wins then current score is LOVE-15`(){
        gameTest.wonPoint("Pedro")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: Love - 15 :Pedro")
    }

    @Test
    fun `when previous score LOVE-15 and player two wins then current score is LOVE-30`(){
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: Love - 30 :Pedro")
    }

    @Test
    fun `when previous score LOVE-30 and player two wins then current score is LOVE-40`(){
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")

        assertThat(gameTest.getScore()).isEqualTo("Sonia: Love - 40 :Pedro")
    }

    @Test
    fun `when each player has 40-40 as score, the score is “deuce”`(){
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
        gameTest.wonPoint("Sonia")
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
    fun `when previous score 40-ADVANTADGE and player one wins then Player 1 wins the GAME`(){
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")

        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Win for Sonia")
    }
    @Test
    fun `when previous score 40-40 and player two wins then current score is 40-ADVANTAGE`(){
        val player1Points = gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Sonia")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")
        gameTest.wonPoint("Pedro")

        val result = gameTest.getScore()
        assertThat(result).isEqualTo("Advantage for Pedro")
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
/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tennis.kata.accelerate

class Player(val name: String){
    var points = 0
}

class Game(val player1: Player, val player2: Player) {

    var player1Points = player1.points
    var player2Points = player2.points

    fun getScore(): String {

        val scores = listOf("Love", "15", "30", "40")

        if (player1Points + player1Points < 6) {
                return "${player1.name}: ${scores[player1Points]} - ${scores[player2Points]} :${player2.name}"
        }
        return advantageOrWin(player1Points, player2Points)


    }

    fun wonPoint(playerName: String) {
        if (playerName == player1.name) {
            player1Points++
        } else {
            player2Points++
        }
    }

    fun advantageOrWin(player1Points: Int, player2Points: Int): String {
        var score: String
        val pointDifference = player1Points - player2Points
        score = when {
            pointDifference == 0 -> "Deuce"
            pointDifference == 1 -> "Advantage for ${player1.name}"
            pointDifference == -1 -> "Advantage for ${player2.name}"
            pointDifference >= 2 -> "Win for ${player1.name}"
            else -> "Win for ${player2.name}"
        }
        return score
    }
}

fun main() {

    val tennisGame = Game(Player("Natalia"), Player("Enrique"))
    tennisGame.wonPoint("Enrique")
    tennisGame.wonPoint("Natalia")
    tennisGame.wonPoint("Natalia")
    tennisGame.wonPoint("Enrique")
    tennisGame.wonPoint("Enrique")
    //tennisGame.wonPoint("Natalia")
    //tennisGame.wonPoint("Enrique")
    //tennisGame.wonPoint("Enrique")

    println(tennisGame.getScore())

}

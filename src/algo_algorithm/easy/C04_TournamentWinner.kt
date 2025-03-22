package algo_algorithm.easy

class C04_TournamentWinner {

    fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
        var bestTeam = ""
        val scores = mutableMapOf(bestTeam to 0)
        competitions.forEachIndexed { index, competition ->
            val (homeTeam, awayTeam) = competition
            val winningTeam = if (results[index] == 0) awayTeam else homeTeam

            scores.put(winningTeam, scores.getOrDefault(winningTeam, 0) + 3)

            if (scores.get(winningTeam)!! > scores.get(bestTeam)!!) {
                bestTeam = winningTeam
            }
        }
        return bestTeam
    }
}
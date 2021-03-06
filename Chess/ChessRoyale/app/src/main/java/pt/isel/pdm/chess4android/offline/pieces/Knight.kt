package pt.isel.pdm.chess4android.offline.pieces

import kotlinx.parcelize.Parcelize

@Parcelize
class Knight(override val team: Team, override var location: Location) : Piece(location, team, 'N') {

    enum class Moves (val x: Int, val y: Int) {
        MOVE1(-2, -1),
        MOVE2(-2, 1),
        MOVE3(2, -1),
        MOVE4(2, 1),
        MOVE5(-1, -2),
        MOVE6(-1, 2),
        MOVE7(1, -2),
        MOVE8(1, 2);
    }

    override fun checkPosition(board: List<List<Piece>>): List<Location> {
        val positions = mutableListOf<Location>()
        Moves.values().forEach {
            val newLocation = location.computeLocation(it.x, it.y)
            if (newLocation.checkLimits()) {
                val piece = board[newLocation.y][newLocation.x]
                if (piece.team == Team.SPACE || piece.team != team) {
                    positions.add(newLocation)
                }
            }
        }
        return positions
    }
}
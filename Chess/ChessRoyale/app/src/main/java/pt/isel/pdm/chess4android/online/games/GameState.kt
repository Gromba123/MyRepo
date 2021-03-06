package pt.isel.pdm.chess4android.online.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import pt.isel.pdm.chess4android.offline.pieces.Team

/**
 * Defines all the possible game states
 */
enum class GameState {Free, Xeque, XequeMate, Forfeit, Draw}

/**
 * Represents an online move
 */
@Parcelize
data class OnlineGameState(
    val id: String,
    val moves: String,
    val state: GameState,
    val player: Team
): Parcelable

/**
 * Converts the last board to a move
 */
fun OnlineBoard.toGameState(
    gameId: String,
    lastMove: String = this.lastMove,
    gameState: GameState = this.gameState
): OnlineGameState =
    OnlineGameState(gameId, lastMove, gameState, playerTeam)
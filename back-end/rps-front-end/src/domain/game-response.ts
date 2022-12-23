import { GameResult } from "./game-result";
import { RPSOption } from "./rps-option";

export class GameResponse {
    firstPlayerOption : RPSOption;
    computerOption : RPSOption;
    gameResult : GameResult;

    constructor(firstPlayerOpt : RPSOption, computerOpt : RPSOption, result : GameResult){
        this.firstPlayerOption = firstPlayerOpt;
        this.computerOption = computerOpt;
        this.gameResult = result;
    }
}
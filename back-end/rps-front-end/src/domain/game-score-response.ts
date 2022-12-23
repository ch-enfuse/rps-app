export class GameScoreResponse {
    ties:number;
    firstPlayerWins:number;
    secondPlayerWins:number;

    constructor(ties : number, firstPlayerWins : number, seconPlayerWins :number){
        this.ties = ties;
        this.firstPlayerWins = firstPlayerWins;
        this.secondPlayerWins = seconPlayerWins;
    }
}
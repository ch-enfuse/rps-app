import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { GameRequest } from "src/domain/game-request";
import { GameResponse } from "src/domain/game-response";
import { GameScoreResponse } from "src/domain/game-score-response";

@Injectable({providedIn:'root'})
export class GameService {

    public baseUrl = '/'
    constructor(private httpClient : HttpClient){}

    play(gameRequest : GameRequest) : Observable<GameResponse>{
        return this.httpClient.post<GameResponse>(this.baseUrl+"play", gameRequest)
    }

    getScores(playerName :String) : Observable<GameScoreResponse>{
        return this.httpClient.get<GameScoreResponse>(this.baseUrl + "score/" + playerName);
    }
}

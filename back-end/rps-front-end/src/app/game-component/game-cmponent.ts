import { Component, OnInit } from '@angular/core';
import { GameRequest } from 'src/domain/game-request';
import { GameResponse } from 'src/domain/game-response';
import { GameResult } from 'src/domain/game-result';
import { RPSOption } from 'src/domain/rps-option';
import { GameService } from 'src/services/game-service';


@Component({
    selector: 'game-component',
    templateUrl: './game.component.html',
    styleUrls: ['./game.component.css']
  })
  export class GameComponent implements OnInit {

    public _RPSOption = RPSOption;
    public score = {
        player : 0,
        computer : 0,
        tie : 0
    }
    public highestScore = {
        player : 0,
        computer : 0,
        tie : 0
    }
    public playerName : String
    
    gameService : GameService;
    gameResponse : GameResponse | undefined;

    constructor( gameService : GameService){
        this.gameService = gameService;
        this.playerName = "testPlayer";
    }
    ngOnInit(): void {
        setInterval(()=> { 
                this.updateHighScores(this.playerName)        
            },
        500);
    }

    play(option: RPSOption) : void {
        this.gameService?.play(new GameRequest(option)).subscribe(response => {
            this.gameResponse = response;
            const result = response.gameResult;
            if(this.gameResponse.gameResult==GameResult.FIRST_PLAYER_LOSS){
                this.score.computer++
            }
            else if(this.gameResponse.gameResult==GameResult.FIRST_PLAYER_WIN){
                this.score.player++;
            }
            else{
                this.score.tie++;
            }
        })
    }
    updateHighScores(player:String){
        this.gameService?.getScores(player).subscribe(response => {
            this.highestScore.tie = response.ties;
            this.highestScore.player = response.firstPlayerWins;
            this.highestScore.computer = response.secondPlayerWins;
        })
    }
    
    
  
  }
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of  } from 'rxjs';
import { GameRequest } from 'src/domain/game-request';
import { GameResponse } from 'src/domain/game-response';
import { GameResult } from 'src/domain/game-result';
import { RPSOption } from 'src/domain/rps-option';
import { GameService } from 'src/services/game-service';
import { GameComponent } from './game-cmponent';

class MockGameService {
    play(gameRequest : GameRequest) : Observable<GameResponse> {
        if(gameRequest.playerOption == RPSOption.ROCK){
            return of(new GameResponse(gameRequest.playerOption, RPSOption.ROCK, GameResult.TIE))
        }
        else if(gameRequest.playerOption == RPSOption.PAPPER){
            return of(new GameResponse(gameRequest.playerOption, RPSOption.ROCK, GameResult.FIRST_PLAYER_WIN))
        }
        else{
            return of(new GameResponse(gameRequest.playerOption, RPSOption.ROCK, GameResult.FIRST_PLAYER_LOSS))
        }
    }
}


describe( 'GameComponent', () =>{
    let mockGameService : MockGameService;
    let gameComponent : GameComponent;
    let fixture : ComponentFixture<GameComponent>;
    beforeEach(() => {
        TestBed.configureTestingModule({ providers: [
            GameComponent,
            {provide:GameService, useClass:MockGameService}], 
            teardown: { destroyAfterEach: false }});
    
        mockGameService = TestBed.inject(GameService);
        gameComponent = TestBed.inject(GameComponent);
        fixture = TestBed.createComponent(GameComponent);
        fixture.detectChanges(); //TestBed.createComponent does not detect changes when creating a component
      });

    it("should load component and set up buttons", ()=>{
        let buttons = fixture.nativeElement.querySelectorAll('button')
        expect(buttons).toBeTruthy();
        expect(buttons.length).toBe(5);
    })
    it("should load component and set up score elements", ()=>{
        let buttons = fixture.nativeElement.querySelectorAll('.score-item')
        expect(buttons).toBeTruthy();
        expect(buttons.length).toBe(6);
    })
    it('load component should set up game score to 0', () => {
        expect(gameComponent.score.player).toBe(0)
        expect(gameComponent.score.computer).toBe(0)
        expect(gameComponent.score.tie).toBe(0)
    })
    it('should bind scores to elements to be 0',()=>{
        let scoreSpans  = fixture.nativeElement.querySelectorAll('.score-item-score');
        for (let i = 0; i < scoreSpans.length; ++i) {
            expect(scoreSpans[i].textContent).toBe('0');
          }
    } )

    it("should update only tie score",()=>{
        gameComponent.play(RPSOption.ROCK);
        expect(gameComponent.score.tie).toBe(1)
        expect(gameComponent.score.player).toBe(0)
        expect(gameComponent.score.computer).toBe(0)
    })
    it("should update only player score",()=>{
        gameComponent.play(RPSOption.PAPPER);
        expect(gameComponent.score.player).toBe(1)
        expect(gameComponent.score.tie).toBe(0)
        expect(gameComponent.score.computer).toBe(0)
    })
    it("should update  only computer score",()=>{
        gameComponent.play(RPSOption.SCISSORS);
        expect(gameComponent.score.computer).toBe(1)
        expect(gameComponent.score.tie).toBe(0)
        expect(gameComponent.score.player).toBe(0)
    })


}

)
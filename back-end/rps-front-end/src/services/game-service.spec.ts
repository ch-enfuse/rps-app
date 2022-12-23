import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { GameRequest } from 'src/domain/game-request';
import { GameResult } from 'src/domain/game-result';
import { RPSOption } from 'src/domain/rps-option';
import { GameService } from './game-service';


describe('GameService', () => {
    let service: GameService;
    let httpMock: HttpTestingController;
    beforeEach(() => {
        TestBed.configureTestingModule({
          imports: [HttpClientTestingModule],
          providers: [GameService],
          teardown: { destroyAfterEach: false }
        });
        service = TestBed.inject(GameService);
        httpMock = TestBed.inject(HttpTestingController);
      });
    it('should return response', () => {
        const dummyResponse = {
        computerOption:RPSOption.PAPPER,
        firstPlayerOption:RPSOption.ROCK,
        gameResult:GameResult.FIRST_PLAYER_LOSS
        }
    
        service.play(new GameRequest(RPSOption.PAPPER)).subscribe(dataResponse => {
        expect(dataResponse.computerOption).toBe(RPSOption.PAPPER)
        expect(dataResponse.firstPlayerOption).toBe(RPSOption.ROCK);
        expect(dataResponse.gameResult).toBe(GameResult.FIRST_PLAYER_LOSS);
        });
    
        const req = httpMock.expectOne(`${service.baseUrl}\play`);
        expect(req.request.method).toBe("POST");
        req.flush(dummyResponse);
        httpMock.verify()
    });

  });
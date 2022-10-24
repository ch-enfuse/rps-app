import { RPSOption } from "./rps-option";
export class  GameRequest{
    playerOption : RPSOption;
    playerName : String;
    constructor(playerOption: RPSOption){
        this.playerOption = playerOption;
        this.playerName = "testPlayer";
    }
}
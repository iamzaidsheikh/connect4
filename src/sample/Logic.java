package sample;

public class Logic {
    private int[][] gameState;
    private int turn;
    private boolean isGameRunning;
    private boolean hasDrawn = false;

    public Logic() {
        this.gameState = new int[6][7];
        this.turn = 1;
        this.isGameRunning = true;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isDrawn() {
        return hasDrawn;
    }

    public boolean checkIsGameRunning() {
        return isGameRunning;
    }

    //Method to play a turn
    public String playTurn(int column){
        return fillCells(column);
    }
    
    //Method that finds which cell to fill and returns the key for imageView
    private String fillCells(int column){
        for(int row = 5;row>-1;row--){
            if(this.gameState[row][column] == 0){
                this.gameState[row][column] = turn;
                checkDraw();
                checkWin();
                //Switch turn
                if(turn==1){
                    turn=7;
                }else if(turn==7){
                    turn = 1;
                }
                //Return the string that acts as the key for imageView map
                return Integer.toString(row) + column;
            }
        }
        return "filled";
    }

    //Method to check is a player has won
    private void checkWin(){
        checkVertical();
        checkHorizontal();
        checkDiagonal1();
        checkDiagonal2();
    }

    //Method to checkDraw
    private void checkDraw(){
        boolean hasDrawn = true;
        for(int row=0;row<6;row++){
            for(int column=0;column<7;column++){
                if(gameState[row][column]==0){
                    hasDrawn=false;
                    break;
                }
            }
        }
        isGameRunning=!hasDrawn;
        this.hasDrawn=hasDrawn;
    }

    //Method to restart the game
    public void restartGame(){
        this.gameState = new int[6][7];
        this.turn=1;
        this.isGameRunning=true;
    }
    
    //Method to check vertical combination
    private void checkVertical(){
        if(isGameRunning){
            for(int column=0;column<7;column++){
                for(int row = 5;row>2;row--){
                    if((gameState[row][column]
                            + gameState[row -1][column]
                            + gameState[row -2][column]
                            + gameState[row -3][column]) == 4*turn){
                        isGameRunning=false;
                        break;
                    }
                }
            }
        }
    }

    //Method to check for horizontal combination
    private void checkHorizontal(){
        if(isGameRunning){
            for(int row=5;row>-1;row--){
                for(int column=0;column<4;column++){
                    if(
                            (gameState[row][column]) +
                                    (gameState[row][column+1]) +
                                    (gameState[row][column+2]) +
                                    (gameState[row][column+3])
                                    ==4*turn
                    ){
                        isGameRunning=false;
                        break;
                    }
                }
            }
        }
    }

    //Method to check diagonal combination for / forward slash
    private void checkDiagonal1(){
        if(isGameRunning){

            if(
                    (gameState[3][1] + gameState[2][1] + gameState[1][2] + gameState[0][3])== 4*this.turn ||
                            (gameState[4][0] + gameState[3][1] + gameState[2][2] + gameState[1][3])== 4*this.turn ||
                            (gameState[3][1] + gameState[2][2] + gameState[1][3] + gameState[0][4])== 4*this.turn ||
                            (gameState[5][0] + gameState[4][1] + gameState[3][2] + gameState[2][3])== 4*this.turn ||
                            (gameState[4][1] + gameState[3][2] + gameState[2][3] + gameState[1][4])== 4*this.turn ||
                            (gameState[3][2] + gameState[2][3] + gameState[1][4] + gameState[0][5])== 4*this.turn ||
                            (gameState[3][3] + gameState[2][4] + gameState[1][5] + gameState[0][6])== 4*this.turn ||
                            (gameState[5][1] + gameState[4][2] + gameState[3][3] + gameState[2][4])== 4*this.turn ||
                            (gameState[4][2] + gameState[3][3] + gameState[2][4] + gameState[1][5])== 4*this.turn ||
                            (gameState[4][3] + gameState[3][4] + gameState[2][5] + gameState[1][6])== 4*this.turn ||
                            (gameState[5][2] + gameState[4][3] + gameState[3][4] + gameState[2][5])== 4*this.turn ||
                            (gameState[5][3] + gameState[4][4] + gameState[3][5] + gameState[2][6])== 4*this.turn
            ){
                isGameRunning=false;
            }
        }
    }

    //Method to check diagonal combination for \ backward slash
    private void checkDiagonal2(){
        if(isGameRunning){

            if(
                //(gameState[3][0] + gameState[4][1] + gameState[5][2] + gameState[6][3])== 4*this.turn ||
                    (gameState[2][0] + gameState[3][1] + gameState[4][2] + gameState[5][3])== 4*this.turn ||
                            (gameState[2][3] + gameState[3][4] + gameState[4][5] + gameState[5][6])== 4*this.turn ||
                            (gameState[1][0] + gameState[2][1] + gameState[3][2] + gameState[4][3])== 4*this.turn ||
                            (gameState[2][1] + gameState[3][2] + gameState[4][3] + gameState[5][4])== 4*this.turn ||
                            (gameState[0][2] + gameState[1][3] + gameState[2][4] + gameState[3][5])== 4*this.turn ||
                            (gameState[0][0] + gameState[1][1] + gameState[2][2] + gameState[3][3])== 4*this.turn ||
                            (gameState[1][1] + gameState[2][2] + gameState[3][3] + gameState[4][4])== 4*this.turn ||
                            (gameState[2][2] + gameState[3][3] + gameState[4][4] + gameState[5][5])== 4*this.turn ||
                            (gameState[0][1] + gameState[1][2] + gameState[2][3] + gameState[3][4])== 4*this.turn ||
                            (gameState[1][2] + gameState[2][3] + gameState[3][4] + gameState[4][5])== 4*this.turn ||
                            (gameState[1][3] + gameState[2][4] + gameState[3][5] + gameState[4][6])== 4*this.turn ||
                            (gameState[0][3] + gameState[1][4] + gameState[2][5] + gameState[3][6])== 4*this.turn
            ){
                isGameRunning=false;
            }
        }
    }
}

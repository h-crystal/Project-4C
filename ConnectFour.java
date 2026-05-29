/* 
AP CS A 
Name: Crystal Harris
Date: 5/28/26
Teacher: MS. Gee
Assignment: 4.0C - Connect Four 
Desciption: In thsi project the user will be playing connecet four
*/
import java.util.Scanner;

public class ConnectFour { 


    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        String [][] grid= new String[6][7]; //six rows of spaces
        //grid[6][7]={" "," "," "," "," "," "};

        boolean gamePlaying= true;
        int turn=0;
        String redDisk=null;
        String yellowDisk=null;
        int pieceCol;

        System.out.println("Welcome to Connect Four! Let's Start!");
        while (gamePlaying==true){
            
            if(turn%2==0){
                System.out.println("Player 1, drop your red disk at column (0-6): ");
                pieceCol= input.nextInt();

            }

            else{
                System.out.println("Player 2, drop your yellow disk at column (0-6): ");
                pieceCol= input.nextInt();

            }

            displayGrid(grid);
            checkHorizontal(grid);
    /*
            checkMinor(grid);
            */
           if (checkHorizontal(grid)){ 
                checkHorizontal(grid);
                gamePlaying = false;
            }

            else if (checkVertical(grid)){ 
                checkVertical(grid);
                gamePlaying = false;
            }

            else if (checkMajor(grid)){
                checkMajor(grid); 
                gamePlaying = false;
            }

            else if (checkMinor(grid)){ 
                checkMinor(grid);
                gamePlaying = false;
            }

            else{
                turn++;
            }
        }

    }    

    public String displayGrid(String[][] grid){

        for(int row= 0; row<grid.length ;row++){
            System.out.print("|");

            for(int col=0;col<grid.length[0]; col++){


                System.out.print(grid[row][col]+"|");

                if(turn%2==0){
                    System.out.print("R");
                }

                else{
                    System.out.print("Y");
                }
                
            }
        }

    }

    public boolean checkHorizontal(String[][] grid){

        boolean win=false;
        int scoreR=0;
        int scoreY=0;

        for(int row=0;row<grid.length; row++){

            for(int col= 0; col<grid[0].length ;col++){
                String check= grid[row][col];
                if(check.equals("R")){
                    scoreR++;
                }      

                else if(check.equals("Y")){
                    scoreY++;
                } 
            }
        }

        if(scoreR==4){
            System.out.println("Player 1 won");
            win= true;
        }

        else if(scoreY==4){
            System.out.println("Player 2 won");
            win= true;
        }

        return win;
    }



    public boolean checkVertical(String[][] grid){
        boolean win=false;
        int scoreR=0;
        int scoreY=0;

        for(int col= 0; col<grid[0].length ;col++){

            for(int row=0;row<grid.length; row++){
                String check= grid[row][col];
                if(check.equals("R")){
                    scoreR++;
                }      

                else if(check.equals("Y")){
                    scoreY++;
                } 
            }
        }

        if(scoreR==4){
            System.out.println("Player 1 won");
            win= true;
        }

        else if(scoreY==4){
            System.out.println("Player 2 won");
            win= true;
        }

        return win;
    }

/*
    public boolean checkMajor(String[][] grid){
        boolean win=false;

    }

    public boolean checkMinor(String[][] grid){
        boolean win=false;

    }
*/
}

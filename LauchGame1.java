package Ai;

	import java.util.Random;
    import java.util.Scanner;

	class TicTacToe1 {
		 static char[][]board;
	     public TicTacToe1()
	     {
	    	 board=new char[3][3];
	    	 initBoard();
	     }
	      void initBoard()
	     {
	    	 for(int i=0;i<board.length;i++)
	    	 {
	    		 for(int j=0;j<board[i].length;j++)
	    		 {
	    			 board[i][j]=' ';
	    		 }
	    	 }
	    }
	      static void dispBoard()
	     {
	    	
	    	 System.out.println("-------");
	    	 for(int i=0;i<board.length;i++)
	    	 {
	    		 System.out.print("|");
	    		 for(int j=0;j<board[i].length;j++)
	    		 {
	    			 System.out.print(board[i][j]+"|");
	    		 }
	    	 
	    		 System.out.println();
	    		 System.out.println("-------");
	    	 }
	    		
	     } 
	       static void placeMark(int row,int column,char mark)
	     {
	    	 if(row>=0 && row<=2 && column>=0 && column<=2)
	    	 {
	    		 board[row][column]=mark;
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Invalid Position");
	    	 }
	     }
	     static boolean checkColWin()
	     {
	    	 for(int j=0;j<=2;j++)
	    	 { 
	    		 if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
	    		 {
	    			 return true;
	    		 }
	    	 }
	    	 return false;
	     }
	     static boolean checkRowWin()
	     {
	    	 for(int i=0;i<=2;i++)
	    	 {
	    		 if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
	    		 {
	    			 return true;
	    		 }
	    	 }
	    	 return false;
	     }
	     static boolean checkDiagWin()
	     {
	    	 if((board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] )||(board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]== board[2][0]))
	    	 {
	    		 return true;
	    	 }
	    	 else
	    	 {
	    		 return false;
	    	 }
	     }
	     static boolean checkDraw()
	     {
	    	 for(int i=0;i<=2;i++)
	    	 {
	    		 for(int j=0;j<=2;j++)
	    		 {
	    			if(board[i][j]==' ') 
	    			{
	    				return false;
	    			}
	    		 }
	    	 }
	    	 return true;
	     }
	         
	    }
	abstract class Player{
		String name;
		char mark;
		 
		abstract void makeMove();
		 boolean isValidMove(int row,int column)
    	 {
    		 if(row>=0 && row<=2 && column>=0 && column<=2)
    		 {
    			if(TicTacToe1.board[row][column]==' ')
    			{
    				return true;
    			}
    		 }
    		 System.out.print("INVALID MOVE");
    		 return false;
    	 }
		
	}
	     class HumanPlayer1 extends Player
	     {  	
	    	 HumanPlayer1(String name,char mark)
    	 {
    		 this.name=name;
    		 this.mark=mark;
    	 }
		
	    	 void makeMove()
	    	 { 
	    		 int row;
	    		 int column;
	    		 Scanner scan=new Scanner(System.in);
	    		 do
	    		 {
	    			 System.out.println("Enter the row and column");
	    			  row=scan.nextInt();
	        		  column=scan.nextInt();
	    		 }
	    		 while(!isValidMove(row,column));
	    		 TicTacToe1.placeMark(row, column, mark);
	    	
	    		 
	    	 }
	    	
	     }
	     class AIPlayer extends Player
	     {
	    	 AIPlayer(String name,char mark)
	    	 {
	    		 this.name=name;
	    		 this.mark=mark;
	    	 }
			
	    	 void makeMove()
	    	 { 
	    		 int row;
	    		 int column;
	    		 Scanner scan=new Scanner(System.in);
	    		 do
	    		 {
	    			 Random r=new Random();
	    			 row=r.nextInt(3);
	    			 column=r.nextInt(3);
	    		 }
	    		 while(!isValidMove(row,column));
	    		 TicTacToe1.placeMark(row, column, mark);
	    	
	    		 
	    	 }
	    	 boolean isValidMove(int row,int column)
	    	 {
	    		 if(row>=0 && row<=2 && column>=0 && column<=2)
	    		 {
	    			if(TicTacToe1.board[row][column]==' ')
	    			{
	    				return true;
	    			}
	    		 }
	    		 return false;
	    	 }
	     }
	     		 


	public class LauchGame1 {

		public static void main(String[] args) {
			TicTacToe1 t=new TicTacToe1();
		 	HumanPlayer1 p1=new HumanPlayer1("Bob",'X');
		 	AIPlayer p2=new AIPlayer("AI",'O');
		 	
		 	 Player cp;
		 	 cp=p1;
		 	 while(true)
		 	 {
		 	 System.out.println(cp.name+" turn");
		 	 cp.makeMove();
		 	 TicTacToe1.dispBoard();
		 	 if(TicTacToe1.checkColWin() || TicTacToe1.checkRowWin() || TicTacToe1.checkDiagWin())
		 	 {
		 		 System.out.println(cp.name+ " has Won");
		 		 break;
		 	 }
		 	 else if(TicTacToe1.checkDraw())
		 	 {
		 		 System.out.println("Game is a draw");
		 	 }
		 	 else
		 	 {
		 		 if(cp==p1)
		 		 {
		 			 cp=p2;
		 		 }
		 		 else
		 		 {
		 			 cp=p1;
		 		 }
		 	 }
	   	     
		    }
		}

	}


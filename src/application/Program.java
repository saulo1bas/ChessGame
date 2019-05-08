package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessExpection;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.println("Source :");
				ChessPosition source = UI.readChessPosition(sc);
				
				System.out.println();
				System.out.println("Target :");
				ChessPosition target = UI.readChessPosition(sc);
			
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessExpection e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}

package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessExpection;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> capturedPieces = new ArrayList<>();
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				//Enter the source position
				UI.printMatch(chessMatch,capturedPieces);
				System.out.println();
				System.out.print("Source :");
				ChessPosition source = UI.readChessPosition(sc); // 
				
				//Print possible moves for pieces
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(),possibleMoves);
				
				System.out.println();
				System.out.print("Target :");
				ChessPosition target = UI.readChessPosition(sc);
			
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				//Adds captured piece to list of captured pieces
				if(capturedPiece != null) {
					capturedPieces.add(capturedPiece);
				}
			}
			catch(ChessExpection e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, capturedPieces);
	}
	
}

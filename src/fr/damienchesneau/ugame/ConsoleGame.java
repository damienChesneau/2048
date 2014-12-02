/* 
 * Copyright (C) 2014 Vasilis Vryniotis <bbriniotis at datumbox.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.damienchesneau.ugame;

import fr.damienchesneau.ugame.client.ai.dataobjects.ActionStatus;
import fr.damienchesneau.ugame.client.Plateau;

/**
 * The main class of the Game.
 *
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 */
public class ConsoleGame {

    /**
     * Main function of the game.
     *
     * @param args
     * @throws CloneNotSupportedException
     */
    public  void main(String[] args) throws CloneNotSupportedException {
        calculateAccuracy();
    }

    /**
     * Estimates the accuracy of the AI solver by running multiple games.
     *
     * @throws CloneNotSupportedException
     */
    public static void calculateAccuracy() throws CloneNotSupportedException {
        int wins = 0;
        int total = 10;
        System.out.println("Running " + total + " games to estimate the accuracy:");

        for (int i = 0; i < total; ++i) {
            int hintDepth = 7;
            Plateau plateau = new Plateau();
            plateau.startGame();
//            Direction newDir = AIsolver.findBestMove(plateau, hintDepth);
            ActionStatus result = ActionStatus.CONTINUE;
            while (result == ActionStatus.CONTINUE || result == ActionStatus.INVALID_MOVE) {
//                if (plateau.isGameOver()) {
                    plateau = new Plateau();
                    plateau.startGame();
//                }
//                int ezc = AIsolver.direction(newDir, plateau);
                if (result == ActionStatus.CONTINUE || result == ActionStatus.INVALID_MOVE) {
//                    newDir = AIsolver.findBestMove(plateau, hintDepth);
                }
            }

            if (result == ActionStatus.WIN) {
                ++wins;
                System.out.println("Game " + (i + 1) + " - won");
            } else {
                System.out.println("Game " + (i + 1) + " - lost");
            }
        }

        System.out.println(wins + " wins out of " + total + " games.");
    }

}

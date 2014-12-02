package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.client.ai.AIsolver;
import fr.damienchesneau.ugame.client.ai.dataobjects.ActionStatus;
import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.DirectionChoose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class ArtificialInteligentServiceMinMax implements ArtificialInteligentService {

    private static boolean gameSolve = false;

    @Override
    public Map<String, Object> solveGame(GameService gameToClone) throws CloneNotSupportedException {
        while (gameSolve != true) {
            System.out.println("New Game");
            GameService game = (GameService) gameToClone.clone();
            while (game.isInGame()) {
                if (!game.isGameOver()) {
                    DirectionChoose bestDirection = getBestPlat(game);
                    System.out.println("Best dir = " + bestDirection.getDirection().name() + " Score = " + bestDirection.getScore()+" empty="+game.getNumberOfEmptyCells());
                    game.startGame(bestDirection.getPlateau(), bestDirection.getScore());
                } else {
                    System.out.println("Game Over score = " + game.getScore());
                    solveGame(gameToClone);
                }
//                System.out.println("Best dir = " + bestDirection.getDirection().name() + " Score = " + bestDirection.getScore());
            }
        }
        if (gameSolve) {
            System.out.println("-2048-");
        }
        return null;
    }

    private DirectionChoose getBestPlat(GameService p) throws CloneNotSupportedException {
        DirectionChoose best = null;
        int scorebests = 0;
        int visee = 5;
        List<DirectionChoose> sdc = new ArrayList<DirectionChoose>();
        for (int x = 0; x < 10; x++) {
            List<DirectionChoose> bestDir = new ArrayList<DirectionChoose>();
            int scorebest = 0;
            for (int i = 0; i < 4; i++) {
                GameService clone = p.clone();
                List<DirectionChoose> chooses = new ArrayList<DirectionChoose>();
                for (int j = 0; j < visee; j++) {
                    DirectionChoose bestDirection = getBestDirection(clone);
                    switch (bestDirection.getDirection()) {
                        case UP:
                            clone.goUp();
                            break;
                        case DOWN:
                            clone.goDown();
                            break;
                        case LEFT:
                            clone.goLeft();
                            break;
                        case RIGHT:
                            clone.goRight();
                            break;
                    }
                    chooses.add(bestDirection);
                }
                if (chooses.get(chooses.size() - 1).getScore() > scorebest || i == 0) {
                    scorebest = chooses.get(chooses.size() - 1).getScore();
                    bestDir = chooses;
                }
            }
            if (bestDir.get(bestDir.size() - 1).getScore() > scorebest || x == 0) {
                scorebests = bestDir.get(bestDir.size() - 1).getScore();
                sdc = bestDir;
            }
        }
        return sdc.get(sdc.size() - 1);
    }

    private DirectionChoose getBestDirection(GameService p) throws CloneNotSupportedException {
        List<DirectionChoose> allDirectionsTested = testAllDirections(p);
        int size = allDirectionsTested.size();
        DirectionChoose bestDirection = allDirectionsTested.get(0);
        for (int i = 1; i < size; i++) {
            if (allDirectionsTested.get(i).getScore() > bestDirection.getScore()) {
                bestDirection = allDirectionsTested.get(i);
            }
        }
        return bestDirection;
    }

    private List<DirectionChoose> testAllDirections(GameService plateauTOClone) throws CloneNotSupportedException {
        List<DirectionChoose> calulatedDirection = new ArrayList<DirectionChoose>();

        GameService plateau = (GameService) plateauTOClone.clone();
        Map<String, Object> goDown = plateau.goDown();
        int scoreDown = (int) goDown.get(GameService.KEY_SCORE);
        calulatedDirection.add(new DirectionChoose(scoreDown+plateau.getNumberOfEmptyCells(), Direction.DOWN, (int[][]) goDown.get(GameService.KEY_PLATEAU)));

        plateau = (GameService) plateauTOClone.clone();
        Map<String, Object> goUp = plateau.goUp();
        int scoreUp = (int) goUp.get(GameService.KEY_SCORE);
        int[][] platgoUp = (int[][]) goUp.get(GameService.KEY_PLATEAU);
        calulatedDirection.add(new DirectionChoose(scoreUp+plateau.getNumberOfEmptyCells(), Direction.UP, platgoUp));

        plateau = (GameService) plateauTOClone.clone();
        Map<String, Object> goRight = plateau.goRight();
        int scoreRight = (int) goRight.get(GameService.KEY_SCORE);
        int[][] patgoRight = (int[][]) goRight.get(GameService.KEY_PLATEAU);
        calulatedDirection.add(new DirectionChoose(scoreRight+plateau.getNumberOfEmptyCells(), Direction.RIGHT, patgoRight));

        plateau = (GameService) plateauTOClone.clone();
        Map<String, Object> goLeft = plateau.goLeft();
        int scoreLeft = (int) goLeft.get(GameService.KEY_SCORE);
        int[][] platgoLeft = (int[][]) goLeft.get(GameService.KEY_PLATEAU);
        calulatedDirection.add(new DirectionChoose(scoreLeft+plateau.getNumberOfEmptyCells(), Direction.LEFT, platgoLeft));

        return calulatedDirection;
    }

}

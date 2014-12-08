package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.DirectionChoose;
import java.util.ArrayList;
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
                    if (!game.isWin()) {
                        DirectionChoose bestDirection = getBestPlat(game.clone());
                        System.out.println("bBest dir = " + bestDirection.getDirection().name() + " Score = " + bestDirection.getScore() + " empty=" + game.getNumberOfEmptyCells());
                        if (game.getNumberOfEmptyCells() == 1) {
                            System.out.println("dfejhr");
                            break;
                        }
                        if (bestDirection.getGame().isInGame()) {
                            game.startGame(bestDirection.getGame().getPlateau(), bestDirection.getScore());
                        } else {
                            if (bestDirection.getGame().isWin()) {
                                gameSolve = true;
                                System.out.println("Computer win !");
                                return null;
                            } else {

                            }
                            break;
                        }
                    } else {
                        System.out.println("Computer win !");
                    }
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
        int visee = 30;
        List<DirectionChoose> bestDir = new ArrayList<DirectionChoose>();
        int scorebest = 0;
        for (int i = 0; i < 30; i++) {
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
                if (bestDirection.getGame().isWin()) {
                    break;
                }

            }
            if (chooses.get(chooses.size() - 1).getScore() > scorebest || i == 0) {
                scorebest = chooses.get(chooses.size() - 1).getScore();
                bestDir = chooses;
            }
        }

        return bestDir.get(bestDir.size() - 1);
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
        if (!plateau.isGameOver()) {
            Map<String, Object> goDown = plateau.goDown();
            int scoreDown = (int) goDown.get(GameService.KEY_SCORE);

            calulatedDirection.add(new DirectionChoose(scoreDown + plateau.getNumberOfEmptyCells(), Direction.DOWN, plateau));

            plateau = (GameService) plateauTOClone.clone();
            Map<String, Object> goUp = plateau.goUp();
            int scoreUp = (int) goUp.get(GameService.KEY_SCORE);
            int[][] platgoUp = (int[][]) goUp.get(GameService.KEY_PLATEAU);
            calulatedDirection.add(new DirectionChoose(scoreUp + plateau.getNumberOfEmptyCells(), Direction.UP, plateau));
            plateau = (GameService) plateauTOClone.clone();
            Map<String, Object> goRight = plateau.goRight();
            int scoreRight = (int) goRight.get(GameService.KEY_SCORE);
            int[][] patgoRight = (int[][]) goRight.get(GameService.KEY_PLATEAU);
            calulatedDirection.add(new DirectionChoose(scoreRight + plateau.getNumberOfEmptyCells(), Direction.RIGHT, plateau));
            plateau = (GameService) plateauTOClone.clone();
            Map<String, Object> goLeft = plateau.goLeft();
            int scoreLeft = (int) goLeft.get(GameService.KEY_SCORE);
            int[][] platgoLeft = (int[][]) goLeft.get(GameService.KEY_PLATEAU);
            calulatedDirection.add(new DirectionChoose(scoreLeft + plateau.getNumberOfEmptyCells(), Direction.LEFT, plateau));
        }
        return calulatedDirection;
    }

}

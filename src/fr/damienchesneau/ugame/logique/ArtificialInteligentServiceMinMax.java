package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.DirectionChoose;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Implémentation de l'algorithme permettant de résoudre le jeux.
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
class ArtificialInteligentServiceMinMax implements ArtificialInteligentService {

    private static int nbTrials = 0;

    @Override
    public Map<String, Object> solveGame(GameService gameToClone) throws CloneNotSupportedException {
        GameService game = (GameService) gameToClone.clone();
        nbTrials++;
        while (game.isInGame()) {
            DirectionChoose bestDirection = null;
            try {
                bestDirection = getBestPlat(game.clone());
            } catch (NoSuchElementException e) {
                return solveGame(gameToClone);
            }
            System.out.println("bBest dir = " + bestDirection.getDirection().name() + " Score = " + bestDirection.getScore() + " empty=" + game.getNumberOfEmptyCells());
            if (bestDirection.getGame().isInGame() && game.getNumberOfEmptyCells() > 1) {
                game.startGame(bestDirection.getGame().getPlateau(), bestDirection.getScore());
            } else {
                game.startGame(bestDirection.getGame().getPlateau(), bestDirection.getScore());
                doAction(bestDirection, game);
                if (bestDirection.getGame().isWin()) {
                    System.out.println("Computer win ! nb trials=" + nbTrials);
                    return game.getDatas();
                } else {
                    System.out.println("Re-try... nb trials=" + nbTrials);
                    return solveGame(gameToClone);
                }
            }
        }
        return null;
    }

    private DirectionChoose getBestPlat(GameService p) throws CloneNotSupportedException {
        DirectionChoose best = null;
        int scorebests = 0;
        int visee = 200;
        LinkedList<DirectionChoose> bestDir = new LinkedList<>();
        int scorebest = 0;
        for (int i = 0; i < 25; i++) {
            GameService clone = p.clone();
            boolean isInGame = true;
            LinkedList<DirectionChoose> chooses = new LinkedList<>();
            for (int j = 0; j < visee; j++) {
                DirectionChoose bestDirection = getBestDirection(clone);
                if (bestDirection != null) {
                    doAction(bestDirection, clone);
                    chooses.add(bestDirection);
                    isInGame = bestDirection.getGame().isInGame();

                    if (bestDirection.getGame().isWin()) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!chooses.isEmpty()) {
                if (chooses.getLast().getScore() > scorebest || i == 0) {
                    scorebest = chooses.getLast().getScore();
                    bestDir = chooses;
                }
            }

        }
        return bestDir.getLast();
    }

    private void doAction(DirectionChoose direction, GameService game) {
        switch (direction.getDirection()) {
            case UP:
                game.goUp();
                break;
            case DOWN:
                game.goDown();
                break;
            case LEFT:
                game.goLeft();
                break;
            case RIGHT:
                game.goRight();
                break;
        }
    }

    @Override
    public DirectionChoose getBestDirection(GameService p) throws CloneNotSupportedException {
        List<DirectionChoose> allDirectionsTested = testAllDirections(p);
        int size = allDirectionsTested.size();
        DirectionChoose bestDirection = null;
        if (!allDirectionsTested.isEmpty()) {
            bestDirection = allDirectionsTested.get(0);
        }

        for (int i = 1; i < size; i++) {
            if (allDirectionsTested.get(i).getScore() > bestDirection.getScore()) {
                bestDirection = allDirectionsTested.get(i);
            }
        }
        return bestDirection;
    }

    private List<DirectionChoose> testAllDirections(GameService plateauTOClone) throws CloneNotSupportedException {
        List<DirectionChoose> calulatedDirection = new LinkedList<>();
        GameService plateau = (GameService) plateauTOClone.clone();
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
        return calulatedDirection;
    }

}

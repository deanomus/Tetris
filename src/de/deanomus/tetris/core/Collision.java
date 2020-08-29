package de.deanomus.tetris.core;

import de.deanomus.tetris.objects.Block;
import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.objects.GameState;

public class Collision {

    public static boolean collideWithBlock(Block b, int dir) {
        //-1 left , 0 down , 1 rechts

        switch (dir) {
            case -1: //left

                if(b.getY() > 0) {
                    if (b.getX() > 0) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (Game.map[b.getX() + i - 1][b.getY() + j] >= 1) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }

                break;

            case 0: //down
                if (b.getY() + b.getSize() > 1) {
                    if (b.getY() - b.getSize() < 17) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (Game.map[b.getX() + i][b.getY() + j + 1] >= 1) {
                                        Game.spawnNewBlock = true;
                                        fillBlock(b);
                                        return true;
                                    }
                                }
                            }

                        }
                    }
                }
                break;



            case 1: //right

                if(b.getY() > 0) {
                    if (b.getX() < 10) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }

                break;
        }


        return false;
    }

    public static boolean collideInRotation(Block b) {
        int rot = b.getRotation() + 1;

        if (rot == 4)
            rot = 0;

        Block newB = new Block();
        newB.setRotation(rot);
        newB.setBounds(b.getBounds());
        newB.setSize(b.getSize());
        newB.setX(b.getX()-1);
        newB.setY(b.getY());

        if(collideWithWall(newB, 1)) {
            return true;
        }
        newB.setX(b.getX() + 2);
        if(collideWithWall(newB, -1)) {
            return true;
        }

        if (b.getY() > 0) {
            for (int i = 0; i < b.getBounds()[rot].length; i++) {
                for (int j = 0; j < b.getBounds()[rot][i].length; j++) {
                    if (b.getBounds()[rot][i][j] == 1) {
                        if (Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
                            return true;
                        }
                    }
                }
            }
        }



        return false;
    }

    public static boolean collideWithWall(Block b, int dir) {

        switch (dir) {
            case -1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + i == 0) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 0:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getY() + j == 17) {
                                Game.spawnNewBlock = true;
                                fillBlock(b);
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + (i + 2) >= 11) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }


        return false;
    }



    private static void fillBlock(Block b) {
        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                    Game.map[b.getX()+i][b.getY()+j] = b.getTypeValue();
                }
            }
        }
        checkLose();
    }

    public static void checkFullRow(int multiplier) {
        int blocksInRow = 0;
        for (int y = Game.map[0].length - 1; y > 0; y--) {
            for (int x = 0; x < Game.map.length; x++) {
                if (Game.map[x][y] > 0) {
                    blocksInRow++;
                }
            }
            if (blocksInRow == 10) {
                Game.scoreToAdd += (10 * multiplier);
                delRow(y, multiplier);
                break;
            } else {
                blocksInRow = 0;
            }
        }

        Game.score += Game.scoreToAdd;
        Game.scoreToAdd = 0;
        if(Game.score > Game.highscore) {
            Game.highscore = Game.score;
            // !TODO! Saving functionality
        }
    }

    private static void delRow(int row, int multiplier) {
        for (int i = 0; i < Game.map.length; i++) {
            Game.map[i][row] = 0;
        }

        for (int y = row; y > 1; y--) {
            for (int x = 0; x < Game.map.length; x++) {
                Game.map[x][y] = Game.map[x][y-1];
            }
        }

        checkFullRow(multiplier+1);
    }

    private static void checkLose() {
        for (int i = 0; i < Game.map.length; i++) {
            if(Game.map[i][0] > 0) {
                Game.gamestate = GameState.end;
            }
        }
    }


}

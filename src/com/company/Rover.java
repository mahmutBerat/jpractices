package com.company;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Author: Mahmut Berat İmdat
 * 9/22/2018
 */

public class Rover {
    private int pos_x;
    private int pos_y;
    private String direction;
    private int matrix_x;
    private int matrix_y;
    private int directionIndex;
    private String instructions;
    private final List directions = asList("N", "E", "S", "W");

    public Rover(int pos_x, int pos_y, String direction, String instructions) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.direction = direction;
        this.instructions = instructions;
        this.directionIndex = directions.indexOf(direction);
    }

    public String moveOnMatrix() {
        char[] instArr = instructions.toCharArray();
        for (char inst : instArr) {
            if (inst == 'L') {
                directionIndex = (directions.size() + directionIndex - 1) % directions.size();
                direction = turn();
            } else if (inst == 'R') {
                directionIndex = (directions.size() + directionIndex + 1) % directions.size();
                direction = turn();
            } else if (inst == 'M') {
                move();
            }
        }
        return pos_x + " " + pos_y + " " + direction;
    }

    private void move() {
        if (directionIndex % 2 == 0) {
            if (direction.equals("N") && pos_y + 1 <= matrix_y)
                pos_y++;
            else if (direction.equals("S") && pos_y - 1 >= 0)
                pos_y--;
        } else {
            if (direction.equals("E") && pos_x + 1 <= matrix_x)
                pos_x++;
            else if (direction.equals("W") && pos_x - 1 >= 0)
                pos_x--;
        }
    }

    private String turn() {
        return (String) directions.get(directionIndex);
    }

    void setMatrix(int matrix_x, int matrix_y) {
        this.matrix_x = matrix_x;
        this.matrix_y = matrix_y;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "pos_x=" + pos_x +
                ", pos_y=" + pos_y +
                ", matrix_x=" + matrix_x +
                ", matrix_y=" + matrix_y +
                ", direction='" + direction + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}

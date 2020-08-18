package com.zachpellman.dailycodingproblem;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyCodingProblem068 {

    public static int countAttackingBishopPairs(final int boardSize, final List<Bishop> bishops) {

        final Map<AttackVector, List<Bishop>> bishopsOnAttackVector = new HashMap<>();

        for (Bishop bishop : bishops) {
            if (isBishopOnBoard(bishop, boardSize)) {
                getAttackVectors(bishop).forEach(vector -> {

                    if (!bishopsOnAttackVector.containsKey(vector)) {
                        bishopsOnAttackVector.put(vector, new ArrayList<>());
                    }

                    bishopsOnAttackVector.get(vector).add(bishop);
                });
            }
        }

        return bishopsOnAttackVector.values().stream()
                .map(List::size)
                .filter(n -> n > 1)
                .map(DailyCodingProblem068::pairs)
                .reduce(0, Integer::sum);
    }

    private static boolean isBishopOnBoard(Bishop bishop, final int boardSize) {

        return bishop.getColumn() < boardSize && bishop.getRow() < boardSize;
    }

    private static List<AttackVector> getAttackVectors(final Bishop bishop) {

        return ImmutableList.of(
                new AttackVector(1, bishop.getRow() - bishop.getColumn()),
                new AttackVector(-1, bishop.getRow() + bishop.getColumn())
        );
    }

    private static int pairs(final int n) {

        return factorial(n) / 2 * factorial(n - 2);
    }

    private static int factorial(final int n) {

        int factorial = 1;

        for (int i = n; i > 1; i--) {
            factorial *= i;
        }

        return factorial;
    }
}

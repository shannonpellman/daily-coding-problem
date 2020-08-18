package com.zachpellman.dailycodingproblem;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.zachpellman.dailycodingproblem.DailyCodingProblem068.countAttackingBishopPairs;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyCodingProblem068Test {

    @Test
    void boardSizeOfZero() {

        final int boardSize = 0;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0),
                Bishop.of(1, 1)
        );

        assertEquals(0, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void boardSizeOfOne() {

        final int boardSize = 1;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0)
        );

        assertEquals(0, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void noBishopsOnBoard() {

        final int boardSize = 5;
        final List<Bishop> bishops = ImmutableList.of();

        assertEquals(0, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void noBishopsCanAttackEachOther() {

        final int boardSize = 3;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0),
                Bishop.of(1, 0),
                Bishop.of(2, 0)
        );

        assertEquals(0, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void multipleBishopsInSameAttackPath() {

        final int boardSize = 3;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0),
                Bishop.of(1, 1),
                Bishop.of(2, 2)
        );

        assertEquals(3, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void oneBishopCanAttackAllOthers() {

        final int boardSize = 3;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0),
                Bishop.of(0, 2),
                Bishop.of(1, 1),
                Bishop.of(2, 0),
                Bishop.of(2, 2)
        );

        assertEquals(6, countAttackingBishopPairs(boardSize, bishops));
    }

    @Test
    void allButOneBishopCanAttack() {

        final int boardSize = 5;
        final List<Bishop> bishops = ImmutableList.of(
                Bishop.of(0, 0),
                Bishop.of(1, 2),
                Bishop.of(2, 2),
                Bishop.of(4, 0)
        );

        assertEquals(2, countAttackingBishopPairs(boardSize, bishops));
    }
}

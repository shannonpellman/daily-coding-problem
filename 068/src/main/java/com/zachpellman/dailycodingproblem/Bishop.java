package com.zachpellman.dailycodingproblem;

import lombok.Value;

@Value
public class Bishop {

    int column;
    int row;

    public static Bishop of(final int column, final int row) {

        return new Bishop(column, row);
    }
}

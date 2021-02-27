package com.vip.guess.service;

import com.vip.guess.model.Grid;
import com.vip.guess.model.Trophy;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GridServiceImpl implements GridService{

    public static final int STATIC_ROW_NUMBER = 0;

    @Override
    public Grid prepare(Grid grid, List<Trophy> trophies) {
        String[][] gridArray = grid.getGrid();
        trophies.forEach(trophy -> {
            if(getRowColumnValue() == STATIC_ROW_NUMBER){
                int staticRowNumber = getIntegerRandomNumber(grid.getSize());
                int minColNumber = getIntegerRandomNumber(grid.getSize() - trophy.getLength() + 1);
                for (int index = 0; index < trophy.getLength(); index++){
                    gridArray[staticRowNumber][minColNumber++] = trophy.getName();
                }
            }else {
                int staticColNumber = getIntegerRandomNumber(grid.getSize());
                int minRowNumber = getIntegerRandomNumber(grid.getSize() - trophy.getLength() + 1);
                for (int index = 0; index < trophy.getLength(); index++){
                    gridArray[minRowNumber++][staticColNumber] = trophy.getName();
                }
            }
        });
        System.out.println(Arrays.deepToString(gridArray));
        return new Grid(gridArray, grid.getSize());
    }

    @Override
    public boolean isTrophyPresent(Grid grid, int row, int col) {
        String[][] gridArray = grid.getGrid();
        return Objects.nonNull(gridArray)
                && Objects.nonNull(gridArray[row][col])
                && Strings.isNotEmpty(gridArray[row][col]);
    }

    @Override
    public Optional<Trophy> getTrophy(Grid grid, int row, int col) {
        if(isTrophyPresent(grid, row, col)){
            return Optional.of(new Trophy(grid.getGrid()[row][col]));
        }
        return Optional.empty();
    }

    @Override
    public void removeTrophy(Grid grid, Trophy trophy) {
        String trophyName = trophy.getName();
        String[][] gridArray = grid.getGrid();
        for ( int i = 0; i < gridArray.length; i++){
            for (int j = 0; j < gridArray.length; j++){
                if(trophyName.equalsIgnoreCase(gridArray[i][j])){
                    gridArray[i][j] = null;
                }
            }
        }
    }

    private  int getRowColumnValue(){
        return getIntegerRandomNumber(2);
    }

    private   int getIntegerRandomNumber(int max) {
        return (int) ((Math.random() * (max - 0)) + 0);
    }


}

package com.vip.guess.service;

import com.vip.guess.model.Grid;
import com.vip.guess.model.Trophy;

import java.util.List;
import java.util.Optional;

public interface GridService {
    public Grid prepare(Grid grid, List<Trophy> trophies);

    public boolean isTrophyPresent (Grid grid, int row, int col);

    public Optional<Trophy> getTrophy (Grid grid, int row, int col);

    public void removeTrophy (Grid grid, Trophy trophy);

}

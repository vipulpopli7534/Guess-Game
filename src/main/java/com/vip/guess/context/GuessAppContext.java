package com.vip.guess.context;

import com.vip.guess.model.Grid;
import com.vip.guess.model.Trophy;
import com.vip.guess.service.GridService;
import com.vip.guess.service.GridServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/*Java configuration typically uses @Bean-annotated methods within a @Configuration class.
 The @Bean annotation on a method indicates that the method creates a Spring bean. Moreover,
  a class annotated with @Configuration indicates that it contains Spring bean configurations.*/

@Configuration
public class GuessAppContext {

    @Autowired
    private Environment environment;

    @Bean
    public Grid getGrid(){
        int size = Integer.parseInt(Objects.requireNonNull(environment.getProperty("vip.guess.game.grid.size")));
        return new Grid(size);
    }

    @Bean
    public List<Trophy> getTrophies(){
        int size = Integer.parseInt(Objects.requireNonNull(environment.getProperty("vip.guess.trophy.quantity")));
        int length = Integer.parseInt(Objects.requireNonNull(environment.getProperty("vip.guess.trophy.length")));
        String defaultName = "trophy";
        List<Trophy> trophies = new ArrayList<>();
        IntStream.range(0,size).forEach(index -> trophies.add(new Trophy(defaultName + index, length)));
        return trophies;
    }

    @Bean
    public Grid prepareGrid(Grid grid, List<Trophy> trophies, GridService gridService){
        return gridService.prepare(grid, trophies);
    }

    @Bean
    public GridService getGridService(){
        return new GridServiceImpl();
    }

}

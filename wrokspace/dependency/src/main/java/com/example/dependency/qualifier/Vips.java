package com.example.dependency.qualifier;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@Qualifier("vips")
public class Vips implements Restaurant {
    private int streakPrice;

    public Vips(){
        this.streakPrice = Restaurant.steakPrice - 10000;
    }

    @Override
    public boolean isSaladBar() {
        return true;
    }
}

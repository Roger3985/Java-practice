package com.example.basic.lesson17.example.api.impl;

import com.example.basic.lesson17.example.api.Player;
import com.example.basic.lesson17.example.api.PlayerProvider;

public class ConsolePlayerProvider implements PlayerProvider {
    @Override
    public Player player() {
        return (Player) new ConsolePlayerProvider();
    }
}

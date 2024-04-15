package com.github.jianlu8023.utils.generator;

import java.util.*;

public abstract class Generator {

    public abstract String generator();

    private static Random random = null;

    protected Random getRandomInstance() {
        if (random == null) {
            random = new Random(new Date().getTime());
        }

        return random;
    }

}

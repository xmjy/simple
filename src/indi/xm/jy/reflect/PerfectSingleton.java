package indi.xm.jy.reflect;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class PerfectSingleton implements Serializable {

    private static final PerfectSingleton INSTANCE = new PerfectSingleton();

    private PerfectSingleton() {
        if (INSTANCE != null) {
            throw new Error("denied access.");
        }
    }

    public static PerfectSingleton getInstance() {
        return INSTANCE;
    }
}
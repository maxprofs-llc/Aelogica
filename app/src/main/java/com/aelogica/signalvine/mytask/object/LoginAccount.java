package com.aelogica.signalvine.mytask.object;

import java.io.Serializable;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class LoginAccount implements Serializable {
    public final String id;
    public final String name;

    public LoginAccount(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

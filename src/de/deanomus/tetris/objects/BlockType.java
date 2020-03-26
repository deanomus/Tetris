package de.deanomus.tetris.objects;

import de.deanomus.tetris.util.Helper;

public enum BlockType {
    I, O, T, L, J, Z, S;

    public static BlockType rdm() {
        return values()[Helper.rdmInt(0, values().length)];
    }

}

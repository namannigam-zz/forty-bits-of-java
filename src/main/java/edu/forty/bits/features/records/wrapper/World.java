package edu.forty.bits.features.records.wrapper;

import java.util.List;

class World {
    List<Integer> ints;

    public World(List<Integer> ints) {
        this.ints = ints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        return ints.equals(world.ints);
    }

    @Override
    public int hashCode() {
        return ints.hashCode();
    }

    @Override
    public String toString() {
        return "World{" +
                "ints=" + ints +
                '}';
    }
}

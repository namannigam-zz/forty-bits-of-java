package edu.forty.bits;

public record Pair<L, R>(L first, R second) {
    public static <L, R> Pair<L, R> of(L first, R second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "one");
    }
}
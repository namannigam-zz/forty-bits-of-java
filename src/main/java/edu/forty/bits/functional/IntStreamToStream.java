package edu.forty.bits.functional;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IntStreamToStream {

    public Stream<byte[]> toStreamGenerate(final InputStream is, final int bufferSize) {
//        return Stream.of(is.readNBytes(bufferSize));
//        return Stream.of(is.readAllBytes());
        return Stream.generate(() -> {
            try {
                return is.readNBytes(bufferSize);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).takeWhile(b -> b.length > 0);
    }


    public Stream<byte[]> toStream(InputStream is, int bufferSize) {
        return StreamSupport.stream(new ChunkInputStreamSpliterator(is, bufferSize), false);
    }

    public static class ChunkInputStreamSpliterator implements Spliterator<byte[]> {

        private final InputStream is;
        private final int bufferSize;

        public ChunkInputStreamSpliterator(InputStream is, int bufferSize) {
            this.is = is;
            this.bufferSize = bufferSize;
        }

        @Override
        public boolean tryAdvance(Consumer<? super byte[]> action) {
            byte[] bytes;
            try {
                bytes = this.is.readNBytes(this.bufferSize);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            if (bytes.length == 0)
                return false;
            action.accept(bytes);
            return true;
        }

        @Override
        public Spliterator<byte[]> trySplit() {
            return null; // cannot split an InputStream
        }

        @Override
        public long estimateSize() {
            return Long.MAX_VALUE; // unknown
        }

        @Override
        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.NONNULL;
        }

    }
}
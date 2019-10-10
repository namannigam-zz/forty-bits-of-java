package edu.forty.bits.generics;

import java.io.Serializable;
import java.util.*;

public class GenericsUtility {

    public static class Helper {
        static <T> T[] CollectionToArray(Collection<T> collection) {
            return (T[]) collection.toArray();
        }

        static <T> T[] ListToArray(List<T> list, T[] a) {
            return list.toArray(a); // Error
        }
    }

    public static class Attempt {
        void toArrayGeneralized() {
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            String[] arrayFromList = Helper.CollectionToArray(list);
            String[] arrayFromSet = Helper.CollectionToArray(set);
            String[] array = Helper.ListToArray(list, new String[0]);
        }
    }

    private static <E> void addToMatrix(List<? extends E> list, List<List<? extends E>> matrix) {
        matrix.add(list);
    }


    public static void main(String[] args) {
        Attempt attempt = new Attempt();
        attempt.toArrayGeneralized();

        // generic implementation of list<list<? extends E>>
        List<List<? extends Number>> matrix = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        addToMatrix(list, matrix);

        EntityCloneService<? extends AbstractNamedEntityBase> service = new EntityCloneService<AbstractNamedEntityBase>() {
            @Override
            public AbstractNamedEntityBase getByUuid(UUID uuid) {
                return new AbstractNamedEntityBase();
            }

            @Override
            public <S> S getCloneAndSave(S existingEntity) {
                return null;
            }
        };
        AbstractNamedEntityBase entity = service.getByUuid(UUID.randomUUID()); // THIS WORKS because it up casting.
        service.getCloneAndSave(entity);    // now how do I pass entity object such that

        // this won't work
//        Comparator<A<String, Integer>> c = wrap(Integer::compare).thenComparing(wrap(Integer::compare));
        // but this would
        Comparator<A<String, Integer>> comparator = wrap(Integer::compare);
        comparator = comparator.thenComparing(wrap(Integer::compare));

    }

    // interface of type BaseEntity
    public class BaseEntity<I extends Serializable> {
        I id;

        public BaseEntity() {
        }

        public I getId() {
            return id;
        }

        public void setId(I id) {
            this.id = id;
        }

        // also has hashCode() and equals() methods to be based on id
    }

    public interface BaseLookup<Id extends Serializable, T extends BaseEntity<Id>> {
        T findById(Id id);
    }

    public interface EntityCloneService<T extends AbstractNamedEntityBase> {
        T getByUuid(UUID uuid);

        <S> S getCloneAndSave(S existingEntity);
    }


    static class AbstractNamedEntityBase {
    }

    interface A<F, S> {
        F getF();

        S getS();
    }

    private static <F, S> Comparator<A<F, S>> wrap(Comparator<S> c) {
        return (L, R) -> c.compare(L.getS(), R.getS());
    }
}
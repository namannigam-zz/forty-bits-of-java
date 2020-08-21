package edu.forty.bits.features.records;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ConsumeRecord {

    private static ConstFunction.ConstCallable<String> aRecord;

    interface SampleInt<P extends Person> {
        void printName(P personRec);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, ClassNotFoundException {
        ((SampleInt<Person>) personRec -> {
            System.out.println(personRec.lastName() + ":" + personRec.name());
            System.out.println(personRec.lastName() + ":" + personRec.name());
        }).printName(new Person("naman", "nigam"));

        Student student = new Student("naman", 30, 0.45);
        Class<?> studentCls = Class.forName("edu.forty.bits.features.records.Student");
        System.out.println(studentCls.isRecord());


        Person person = new Person("naman", "nigam");
        person.print();
        Class<?> personCls = Class.forName("edu.forty.bits.features.records.Person");
        System.out.println(personCls.isRecord());

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.leak());

        Stream.generate(new ConstFunction.ConstSupplier<>(5)).limit(2).forEach(System.out::println);
        aRecord = new ConstFunction.ConstCallable<>("record");
        System.out.println(ForkJoinPool.commonPool().submit(aRecord).get());
    }
}
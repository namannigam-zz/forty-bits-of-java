package edu.forty.bits.features.records;

import java.util.Optional;

public class NullableAttribute {

    static class MyClassDataAccess {

        Optional<String> getValue(MyClass myClass) {
            return Optional.ofNullable(myClass.value());
        }

        String readId(MyClass myClass) {
            return myClass.id();
        }

        private record MyClass(String id, String value) {
            Optional<String> getValue() {
                return Optional.ofNullable(value());
            }
        }
    }

    interface MyRecord {
        String id();
        Optional<String> value();
    }

    record MyRecordNoValue(String id) implements MyRecord {
        public Optional<String> value() {
            return Optional.empty();
        }
    }

    record MyRecordWithValue(String id, String actualValue) implements MyRecord {
        public Optional<String> value() {
            return Optional.of(actualValue);
        }
    }
}
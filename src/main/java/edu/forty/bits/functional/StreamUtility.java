package com.stackoverflow.nullpointer.stream;

import com.stackoverflow.nullpointer.pojo.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamUtility {

    public static void main(String[] args) {
        System.out.println(findMaxOrMin(List.of(2, 3, 4, 56, 90)));
        System.out.println(filterStringBasedOnCondition(List.of("abc", "", "bc", "efg", "abcd", "", "jkl")));
        System.out.println(convertIntArrayToSet(new int[]{1, 2, 3}));
        System.out.println(listToConsecutiveSubLists(List.of(1, 2, 3, 4, 5, 6, 7), 3));
        System.out.println(Stream.of(1, 3, 5).filter(distinctByKey(Integer::doubleValue)).collect(Collectors.toList()));
        System.out.println(isAnagram(List.of("cat", "cta", "act", "atc", "tac", "tca").toArray(new String[0])));
        System.out.println(mostFrequentStream(List.of("cat", "cat", "act", "atc", "act", "act")));
        System.out.println(sumOfListBigDecimal(List.of(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO)));
        System.out.println(getDeduplicateList(List.of(List.of(0, 1), List.of(1, 2), List.of(3, 2), List.of(2, 3))));
        System.out.println(sameAttributeFilteredFurtherUsingRecentDate(
                List.of(new EmployeeContract(1L, Date.from(Instant.now())),
                        new EmployeeContract(1L, Date.from(Instant.now())),
                        new EmployeeContract(2L, Date.from(Instant.now())),
                        new EmployeeContract(3L, Date.from(Instant.now())))));
        System.out.println(countryWithMostNumberOfStudents(List.of(
                new Student("Jan", 13, Student.Country.POLAND, 92),
                new Student("Anna", 15, Student.Country.POLAND, 95),
                new Student("Helga", 14, Student.Country.GERMANY, 93),
                new Student("Leon", 14, Student.Country.GERMANY, 97),
                new Student("Chris", 15, Student.Country.GERMANY, 97),
                new Student("Michael", 14, Student.Country.UK, 90),
                new Student("Tim", 15, Student.Country.UK, 91),
                new Student("George", 14, Student.Country.UK, 98)
        )));
        Arrays.stream(charToString(new char[][]{{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        })).forEach(System.out::println);
        System.out.println(maxEntryFromAListBasedOnCount(
                List.of(1, 1, 2, 3, 5, 8, 13, 21, 21, 61, 98, 15, 25, 41, 67, 55, 89, 89, 89, 89)));
        System.out.println(sizeOfMaximumSizeSet(Map.of(1, Set.of(1, 2, 3), 4, Set.of(2, 3, 5), 5, Set.of(1, 2, 3, 4, 5))));
        System.out.println(removeFormerDuplicates(List.of("interface", "list", "Primitive", "class", "primitive", "List", "Interface", "lIst", "Primitive")));
        System.out.println(Arrays.toString(sortArrayBasedOnCustomComparison(new int[]{3, 30, 34, 5, 9})));
        printWhileCollecting(List.of(
                new Book(new Author("overflow", 100)),
                new Book(new Author("stack", 80)),
                new Book(new Author("com/stackoverflow/nullpointer", 49))));
        System.out.println(getSum(List.of(new MyDTO(12), new MyDTO(15), new MyDTO(1))));
        System.out.println(getMinimumSizeList(List.of(List.of(0, 2, 3), List.of(0, 2, 3, 4))).size());
        System.out.println(Stream.of().anyMatch(a -> true)); // empty stream anyMatch
        System.out.println(splitStringIntoMap(List.of("10-A", "10-B", "11-C", "11-A")));
        updateAListOfMapOfStrings();
        System.out.println(groupByListAttributeInListOfObject(List.of(new CarShop("ford", 25000, Set.of("black", "white", "red")),
                new CarShop("audi", 30000, Set.of("blue", "white")),
                new CarShop("bmw", 35000, Set.of("black")),
                new CarShop("mersedes", 45000, Set.of("blue", "white", "yellow")))));
    }

    private static Integer findMaxOrMin(List<Integer> list) {
//        return list.stream().min(Comparator.comparingInt(a -> a)).orElse(Integer.MAX_VALUE);
        return list.stream().max(Comparator.comparingInt(a -> a)).orElse(Integer.MIN_VALUE);
    }

    private static void stateFullVsStatelessStream() {
        // stateless
        List.of("One", "Two", "Three").stream()
                .peek(System.out::println)
                .takeWhile(s -> true)
                .forEach(System.out::println);
        // stateful
        List.of("One", "Two", "Three").stream()
                .peek(System.out::println)
                .sorted()
                .forEach(System.out::println);
    }

    private static List<Integer> differenceOfEqualSizeList(List<Integer> a, List<Integer> b) {
        return IntStream.range(0, a.size())
                .mapToObj(i -> a.get(i) - b.get(i))
                .collect(Collectors.toList());
    }

    private static List<String> filterStringBasedOnCondition(List<String> strings) {
        return strings.stream()
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toList());
    }

    private static Set<Integer> convertIntArrayToSet(int[] input) {
        return Arrays.stream(input).boxed().collect(Collectors.toSet());
    }

    private static List<List<Integer>> listToConsecutiveSubLists(List<Integer> list, int subListSize) {
        return IntStream.rangeClosed(0, list.size() - subListSize)
                .mapToObj(i -> list.subList(i, i + subListSize))
                .collect(Collectors.toList());
    }

    private static int indexOfTheListWithTheMinSize(List<List<Integer>> listOLists) {
//        int minIndex1 = IntStream.range(0, listOLists.size()).boxed()
//                .min(Comparator.comparingInt(i -> listOLists.get(i).size()))
//                .orElse(-1);
        return listOLists.indexOf(Collections.min(listOLists, Comparator.comparingInt(List::size)));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @SuppressWarnings("unchecked")
    static <T> Stream<T> reverse(Stream<T> input) {
        Object[] temp = input.toArray();
        return (Stream<T>) IntStream.range(0, temp.length).mapToObj(i -> temp[temp.length - i - 1]);
    }

    private List<Stake> filteredStakeForDistinctCustomer(List<Stake> stakes, int maxBetOfferId) {
        return stakes.stream()
                .filter(s -> s.getBetOfferId() == maxBetOfferId) // maxProductOfNonOverlappingPallindromes betOfferId
                .filter(StreamUtility.distinctByKey(Stake::getCustomerId)) // distinct customer Id
                .limit(20) // limit to 20
                .collect(toList());
    }

    private static boolean isAnagram(String[] list) {
        return Stream.of(list)
                .map(String::toCharArray)
                .peek(Arrays::sort)
                .map(String::valueOf)
                .distinct()
                .count() == 1;
    }

    private static String mostFrequentStream(List<String> elements) {
        Map<String, Long> ordered = elements.stream()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return ordered.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private static BigDecimal sumOfListBigDecimal(List<BigDecimal> input) {
        return input.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static List<String> readLinesOfFile(String pathToFile) {
        // read a file into a list of words with certain conditions
        try (var lines = Files.lines(Path.of(pathToFile))) {
            return lines.map(String::toLowerCase) // step 1
                    .flatMap(str -> Arrays.stream(str.split("[^a-z]+")) // step 2
                            .filter(Predicate.not(String::isEmpty)).sorted() // step 3
                            .distinct())    // step 4
                    .collect(Collectors.toList()); // step 5
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<List<Integer>> getDeduplicateList(List<List<Integer>> lists) {
        return lists.stream()
                .map(HashSet::new)
                .distinct()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }

    private static List<String> fetchItemsWithSpecificCount(List<String> list) {
//        Map<String, Long> result2 = list.stream()
//                .collect(Collectors.groupingBy(Function.identity(),
//                        Collectors.counting()));
//        result2.entrySet().removeIf(v -> v.getValue() == 1);

//        List<String> recurringItems = list.stream()
//                .filter(item -> list.lastIndexOf(item) != list.indexOf(item))
//                .collect(Collectors.toList());

        return list.stream()
                .filter(x -> list.stream().filter(x::equals).count() >= 2)
                .distinct()
                .collect(toList());
    }


    private static List<EmployeeContract> sameAttributeFilteredFurtherUsingRecentDate(List<EmployeeContract> contract) {
//        List<EmployeeContract> finalContract = contract.stream()
//                .collect(Collectors.toMap(EmployeeContract::getId,
//                        EmployeeContract::getConsultedOn, (a, b) -> a.after(b) ? a : b))
//                .entrySet().stream()
//                .map(a -> new EmployeeContract(a.getKey(), a.getValue()))
//                .collect(Collectors.toList());

        return new ArrayList<>(contract.stream()
                .collect(Collectors.toMap(EmployeeContract::getId, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(EmployeeContract::getDate))))
                .values());
    }


    private static Student.Country countryWithMostNumberOfStudents(List<Student> students) {
        Map<Student.Country, Long> numberOfStudentsByCountry = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));

        Map.Entry<Student.Country, Long> mostFrequentEntry = numberOfStudentsByCountry.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println(mostFrequentEntry);

        return numberOfStudentsByCountry.entrySet()
                .stream()
                .max((Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .orElse(Student.Country.POLAND);
    }

    private static Map.Entry<Integer,Long> maxEntryFromAListBasedOnCount(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static int sizeOfMaximumSizeSet(Map<Integer, Set<Integer>> adj) {
        return adj.values()
                .stream()
                .max(Comparator.comparingInt(Set::size))
                .map(Set::size)
                .orElse(0);
    }

    private static List<Person> filterDistinctElementsOfAList(List<Person> people) {
//        Set<Student> finalListOfStudents = students.stream()
//                .map(x -> nameToStudentMap.merge(x.getConsultedBy(), x, (a, b) -> a.getAge() > b.getAge() ? a : b))
//                .collect(Collectors.toSet());
        return new ArrayList<>(people.stream()
                .collect(Collectors.toMap(a -> a.getName().toLowerCase(),
                        Function.identity(),
                        (person, person2) -> person.getDate().isAfter(person2.getDate()) ? person : person2))
                .values());
    }

    private static String[] charToString(char[][] array) {
        return Arrays.stream(array) //forms a Stream<char[]> (all your rows)
                .map(String::new) // maps the char[] to String forming Stream<String>
                .toArray(String[]::new); // converts the stream to array String[]
    }

    private static List<String> removeFormerDuplicates(List<String> strings) {
        return new ArrayList<>(strings.stream()
                .collect(Collectors.toMap(String::toLowerCase, Function.identity()))
                .values());
    }


    private static int[] sortArrayBasedOnCustomComparison(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingDouble(
                        (Integer x) -> x / (Math.pow(10, x.toString().length() - 1))).reversed())
                .mapToInt(i -> i)
                .toArray();
    }


    private static void printWhileCollecting(List<Book> library) {
        List<String> lastNames = library.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getAge() >= 50)
                .map(Author::getLastName)
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    // convertBinaryArrayToInt(List.of(0, 0, 0, 1)
    private static int convertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream()
                .reduce((x, y) -> x * 2 + y)
                .orElse(0);
    }

    private static Double getSum(List<MyDTO> myDTOList) {
        return myDTOList.stream().filter(Objects::nonNull).mapToDouble(MyDTO::getAmount).sum();
    }


    private static Node createNodeIfValueIsOneOrTwo(ArrayList<Integer> list) {
        return list.stream()
                .filter(l -> l == 1 || l == 2)
                .findAny()
                .map(Node::new)
                .orElse(null);
    }

    private static Map<Long, List<Long>> swapValuesToKeyInAMap(Map<Long, List<Long>> skuMap) {
//        Map<Long, List<Long>> actMap = new HashMap<>();
//        skuMap.forEach((k, v) -> v.forEach(val -> actMap.computeIfAbsent(val, key -> new ArrayList<>()).add(val)));
        return skuMap.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(v -> new AbstractMap.SimpleEntry<>(e.getKey(), v)))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }

    private static List<Integer> getMinimumSizeList(List<List<Integer>> lists) {
        return lists.stream()
                .min(Comparator.comparingInt(List::size))
                .orElse(new ArrayList<>());
    }

    private static String convertTwoDimensionalBoardToString(int[][] board) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        Arrays.stream(board).forEach(aBOARD -> {
            StringJoiner joiner = new StringJoiner(",", "[", "]");
            Arrays.stream(aBOARD).mapToObj(String::valueOf).forEach(joiner::add);
            stringJoiner.add(joiner.toString());
        });
        return stringJoiner.toString();
    }

    private static Map<String, List<String>> splitStringIntoMap(List<String> pendingCpcList) {
        return pendingCpcList.stream().map(rec -> rec.split("-"))
                .collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1], Collectors.toList())));
    }

    private static Map<String, List<Person>> groupPeopleByLanguage(List<Person> people) {
        // group by language since each person knows a List<String> languages
        return people.stream()
                .flatMap(p -> p.getLanguagesSpoken()
                        .stream()
                        .map(l -> new AbstractMap.SimpleEntry<>(l, p)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.toList())));
    }

    private static void updateAListOfMapOfStrings() {
        // alternatively without object creation and using Map<String, String>
        List<Map<String, String>> mapListOne = List.of(Map.of("partyId", "1",
                "accountId", "1",
                "sourceSystem", "1"),
                Map.of("partyId", "2",
                        "accountId", "2",
                        "sourceSystem", "2"));

        List<Map<String, String>> mapListTwo = List.of(Map.of("partyId", "3",
                "accountId", "3",
                "sourceSystem", "3"),
                Map.of("partyId", "1",
                        "accountId", "2",
                        "sourceSystem", "2"));

        List<Map<String, String>> resultMap = Stream.concat(mapListOne.stream(), mapListTwo.stream())
                .collect(Collectors.groupingBy(m -> m.get("partyId"), Collectors.toList()))
                .entrySet().stream()
                .map(e -> e.getValue().get(0))
                .collect(Collectors.toList());
        System.out.println(resultMap);
    }

    private static Map<String, List<CarShop>> groupByListAttributeInListOfObject(List<CarShop> carShops) {
        return carShops.stream()
                .flatMap(e -> e.getColors().stream()
                        .map(v -> new AbstractMap.SimpleEntry<>(v, e)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

    /**
     * @apiNote
     * The {@code filtering()} collectors are most useful when used in a
     * multi-level reduction, such as downstream of a {@code groupingBy} or
     * {@code partitioningBy}.  For example, given a stream of
     * {@code Employee}, to accumulate the employees in each department that have a
     * salary above a certain threshold:
     * <pre>{@code
     * Map<Department, Set<Employee>> wellPaidEmployeesByDepartment
     *   = employees.stream().collect(
     *     groupingBy(Employee::getDepartment,
     *                filtering(e -> e.getSalary() > 2000,
     *                          toSet())));
     */
    private static Map<Department, Set<Employee>> filteringWhileGrouping(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.filtering(e -> e.getSalary() > 2000, Collectors.toSet())));
    }


    /**
     * @apiNote
     * The {@code flatMapping()} collectors are most useful when used in a
     * multi-level reduction, such as downstream of a {@code groupingBy} or
     * {@code partitioningBy}.  For example, given a stream of
     * {@code Order}, to accumulate the set of line items for each customer:
     * <pre>{@code
     * Map<String, Set<LineItem>> itemsByCustomerName
     *   = orders.stream().collect(
     *     groupingBy(Order::getCustomerName,
     *                flatMapping(order -> order.getLineItems().stream(),
     *                            toSet())));
     */
    private Map<String, Set<LineItem>> flatMappingWhileGroupingItemsByCustomerName(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName,
                        Collectors.flatMapping(order -> order.getLineItems().stream(), Collectors.toSet())));
    }

    private void consumeObjectsProvidedBySupplier() {
        Consumer<String> consumer = (String key) -> System.out.println("key=" + key);
        Supplier<String> keyGen = new SimpleKeySupplier("keyPrefix", 4);
        Stream.generate(keyGen).takeWhile(Objects::nonNull).forEach(consumer);
    }


    public static <T> Predicate<T> chainPredicates(Function<T, Predicate<T>> mapFn, T[] args) {
        return Arrays.stream(args).map(mapFn).reduce(a -> true, Predicate::or);
    }

    public IntStream convertOneDimensionalArray(int[] val) {
        return Stream.of(val)
                .flatMapToInt(Arrays::stream);
    }

    public IntStream convertTwoDimensionalArray(int[][] val) {
        return Stream.of(val)
                .flatMapToInt(Arrays::stream);
    }

    public Map<String, Integer> getBestPrices(List<PriceGroup> priceGroups, List<Price> prices) {
        Map<String, Integer> minPrice = prices.stream()
                .collect(Collectors.groupingBy(Price::getPriceName,
                        Collectors.reducing(0, Price::getPrice,
                                BinaryOperator.minBy(Comparator.naturalOrder()))));
        return priceGroups.stream()
                .collect(Collectors.toMap(PriceGroup::getPriceGroup,
                        priceGroup ->
                                minPrice.getOrDefault(priceGroup.getPriceName(), 10000000)));
    }

    private static <T> Stream<T> zipped(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        List<T> elements = new LinkedList<>();
        while (iterator1.hasNext() || iterator2.hasNext()) {
            elements.add(iterator1.next());
            elements.add(iterator2.next());
        }
        return elements.stream();
    }



    @Getter
    public class PriceGroup {
        String priceName;
        String priceGroup;
    }

    @Getter
    public class Price {
        String priceName;
        Integer price;
    }
}
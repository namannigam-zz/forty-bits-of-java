package edu.forty.bits.collections;

import java.util.PriorityQueue;

public class PriorityQSample {

    static class Grade implements Comparable<Grade> {
        private String subject;
        private int grade;

        Grade(String subject, int grade) {
            this.subject = subject;
            this.grade = grade;
        }

        public int compareTo(Grade g) {
            return this.grade - g.grade;
        }

        public String toString() {
            return "sub : " + subject + " -> " + "grade : " + grade;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Grade> pq = new PriorityQueue<>();
        pq.add(new Grade("Python", 2));
        pq.add(new Grade("C++", 3));
        pq.add(new Grade("JAVA", 1));
        pq.forEach(System.out::println); // way to iterate on PQ is not to use 'iterator'
    }
}
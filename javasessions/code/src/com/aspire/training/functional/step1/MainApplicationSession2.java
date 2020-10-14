package com.aspire.training.functional.step1;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.aspire.training.functional.step1.Course.JAVA;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MainApplicationSession2 {


    static Student[] students = new Student[]{
            Student.student("Ahmad", 20, Gender.MALE, true, Course.MATH, Course.CHEMISTRY, JAVA),
            Student.student("Mohammad", 25, Gender.MALE, true, Course.MATH, JAVA),
            Student.student("ESA", 27, Gender.MALE, false, Course.MATH, JAVA),
            Student.student("ESRA", 19, Gender.FEMALE, true, Course.MATH, Course.ENGLISH),
            Student.student("DANA", 40, Gender.FEMALE, true, Course.MATH, Course.ENGLISH, Course.PHYSICS),
            Student.student("RUBA", 22, Gender.FEMALE, true, Course.MATH, Course.PHYSICS)

    };

    public static void main(String[] args) {
//        Stream.of(students)
//                .forEach(x->{
//                    System.out.println(x);
//                });
//
//        Stream.of(students)
//                .map(st-> st.getName())
//                .forEach(x->System.out.println(x));
//
//        Stream.of(students)
//                .map(Student::getName)//method reference st->st.getName()
//                .forEach(System.out::println);// a method reference

//        Stream.of(students)
//                .flatMap(st->st.getCourses().stream())
//                .forEach(System.out::println);


//        Stream.of(students)
//                .filter(Student::isActive)
//                .map(Student::getName)
//                .forEach(System.out::println);

//        Stream.of(students)
//                .filter(st->st.getAge()>35)
//                .map(Student::getName)
//                .forEach(System.out::println);

//        List<String> studentNames = Stream.of(students)
//                .map(Student::getName)
//                .collect(Collectors.toList());
//
//        System.out.println("studentNames = " + studentNames);

//        Map<Gender, List<Student>> studentBasedOnGender =
//                Stream
//                        .of(students)
//                        .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.toList()));
//
//        System.out.println("studentBasedOnGender = " + studentBasedOnGender);

//        Map<Gender, List<String>> studentNameBasedOnGender =
//                Stream
//                        .of(students)
//                        .collect(Collectors.groupingBy(s -> s.getGender(),
//                                Collectors.mapping(s->s.getName(),Collectors.toList())));
//
//        System.out.println("studentNameBasedOnGender = " + studentNameBasedOnGender);


//        Optional<Integer> first =
//                Stream.of(students)
//                        .map(st -> st.getAge())
//                        .findFirst();
//
//        System.out.println("first = " + first);
//        System.out.println("first isPresent= " + first.isPresent());
//
//        Optional<Integer> firstGT100 =
//                Stream.of(students)
//                        .map(st -> st.getAge())
//                        .filter(age -> age > 100)
//                        .findFirst();
//
//        System.out.println("firstGT100 = " + firstGT100);
//        System.out.println("firstGT100 isPresent= " + firstGT100.isPresent());


//        List<Student> orderedStudent = Stream.of(students)
//                .sorted((st1, st2) -> st1.getName().compareTo(st2.getName()))
//                .collect(Collectors.toList());
//
//        System.out.println("orderedStudent = " + orderedStudent);

//        Stream.of(students)
//                .map(Student::getName)
//                .sorted()
//                .forEach(System.out::println);


//        List<Student> orderedStudentDesc = Stream.of(students)
//                .sorted((st1, st2) -> st2.getName().compareTo(st1.getName()))
//                .collect(Collectors.toList());
//
//        System.out.println("orderedStudentDesc = " + orderedStudentDesc);

//        Map<Course, Long> courseStCount =
//                Stream
//                        .of(students)
//                        .flatMap(st -> st.getCourses().stream())
//                        .collect(groupingBy(c -> c, counting()));
//
//        System.out.println("courseStCount = " + courseStCount);
//
//
//        Long javaCount = Stream
//                .of(students)
//                .flatMap(st -> st.getCourses().stream())
//                .filter(c -> c == JAVA)
//                .count();
//
//        System.out.println("javaCount = " + javaCount);

//
//        IntStream
//                .range(0,10)
//                .forEach(System.out::println);
//
//        int sum0To10 = IntStream
//                .range(0, 11)
//                .sum();

//        System.out.println("sum0To10 = " + sum0To10);
//
//        OptionalDouble average = IntStream
//                .range(0, 11)
//                .average();
//
//        System.out.println(average);
//
//        OptionalInt max = IntStream
//                .range(0, 11)
//                .max();
//        System.out.println("max = " + max);

//        List<Student> allStudents = IntStream
//                .range(0, 6)
//                .mapToObj(index -> students[index])
//                .collect(Collectors.toList());
//
//        System.out.println("allStudents = " + allStudents);


//        List<Student> listOfStudent = Stream
//                .of(students)
//                .collect(Collectors.toList());

//        ArrayList<Student> reduce = Stream
//                .of(students)
//                .reduce(new ArrayList<Student>(),
//                        (acc, e) -> {
//                            acc.add(e);//this is not acceptable in pure function
//                            //Create Another List.. and Add all element from acc to that list..then return the new Array List
//                            //to make this function a pure function
////                            ArrayList<Student> newArrayList=new ArrayList<>();
////                            newArrayList.addAll(acc);
//                            return acc;
//                        }, (a, b) -> {
//                            a.addAll(b);
//                            return a;
//                        });
//
//        System.out.println("reduce = " + reduce);

//        Integer maxStAge = Stream
//                .of(students)
//                .reduce(0, (maxAge, st) -> maxAge < st.getAge() ? st.getAge() : maxAge,
//                        (a, b) -> a > b ? a : b);
//
//        System.out.println("maxStAge = " + maxStAge);

//        Integer countOfStudent = Stream
//                .of(students)
//                .reduce(0, (acc, st) -> acc + 1, (a, b) -> a);
//
//        System.out.println("countOfStudent = " + countOfStudent);


        //        Map<Gender, List<Student>> studentBasedOnGender =
//                Stream
//                        .of(students)
//                        .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.toList()));

//        Map<Course,List<Student>> courseGrouping=
//                Stream
//                        .of(students)
//                        .reduce(new HashMap<Course,List<Student>>(),
//                                (acc,st)->{
//                            //do the implementation here
//                            return acc;
//                        },(a,b)->a);


//        Stream
//                .of(students)
//                .skip(2)
//                .forEach(System.out::println);

//        Stream
//                .of(students)
//                .limit(2)
//                .forEach(System.out::println);

//        Stream
//                .iterate(0,a->a+1)
//                .limit(11)
//                .forEach(System.out::println);


//        Stream<String> stringStream = Stream
//                .of(students)
//                .map(st -> {
//                    System.out.println(st.getName());
//                    return st.getName();
//                });
//
//        stringStream
//                .map(name-> {
//                    System.out.println("Inside Hello method");
//                    return "Hello " + name;
//                })
//                .forEach(System.out::println);
    }


}

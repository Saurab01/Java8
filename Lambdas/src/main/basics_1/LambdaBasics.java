package main.basics_1;

import java.util.function.*;

/**
 * Created by saurabhagrawal on 27/12/18.
 */

interface interfaceNoMethod{}

@FunctionalInterface
interface Parent extends interfaceNoMethod{
    public int parentMethod(int a,int b);
    default public int difference(int a,int b){
        return a-b;
    }
}

public class LambdaBasics {

    public static void main(String[] a) {
        LambdaBasics lambdaBasics=new LambdaBasics();
        lambdaBasics.usingAnonyMousClass(2,3);
        lambdaBasics.usinglmbda(4,5);

        //other functional interfaces in java
        lambdaBasics.testPredicate();
        lambdaBasics.testSupplier();
        lambdaBasics.testConsumer();
        lambdaBasics.testFunction();
        lambdaBasics.testBinaryOperator();
    }

    private void usingAnonyMousClass(int num1,int num2){

        final String comment="through anonymous class creation::";
        String non_final_comment=" value::";
        //non_final_comment="valueUpdated";

        Parent parent=new Parent() {
            @Override
            public int parentMethod(int a, int b) {
                System.out.print(comment+non_final_comment);
                return a+b;
            }
        }; //Anonymous class created
        //calling method of anonymous class
        System.out.println(parent.parentMethod(num1,num2));
    }


    private void usinglmbda(int num1,int num2) {

        final String comment="through anonymous class creation::";
        String non_final_comment=" value::";
        //non_final_comment="non_final_comment"; //uncomment this will throw error(as variable in anonymous/lambdas
        // should be final or effectively final(no updation))

        Parent parent=(a,b)->{    //NOTE : type is also not required will inherit from parent interface
            System.out.print(comment+non_final_comment);
            return a+b;
        };
        System.out.println(parent.parentMethod(num1,num2));
    }
//other functional interfaces
    private void testPredicate() {
        //Predicate checks true or false using test mwthod
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println("*********\nPredicate result: "+atLeast5);
        System.out.println("Predicate result: "+atLeast5.test(10));

        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println("BiPredicate:: "+bi.test(2, 3));
    }

    private void testSupplier() {
        Supplier<String> i  = ()-> "Returned value";
        System.out.println("*****\nSupplier:: "+i.get());
    }
    private void testConsumer() {
        Consumer<String> consumer=(x)->System.out.println("Consumer value::"+x.toLowerCase());
        consumer.accept("Returned value");

        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.print(x);
            System.out.println(y);
        };
        biConsumer.accept("BiConsumer", " Results");
    }
    private void testFunction() {
        Function<Integer,String> func=(a)->Integer.toString(a);
        System.out.println("*******\nFunction output=="+func.apply(123));

        BiFunction<String, String,String> bi = (x, y) -> {
            return x + y;
        };
        System.out.println(bi.apply("Bifunction", " results"));
    }

    private void testBinaryOperator() {
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
        System.out.println("Binary Operator result::"+adder.apply(3, 4));
    }
}



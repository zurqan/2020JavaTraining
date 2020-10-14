package com.aspire.training.functional.step0;

public class MainApplicationSession1 {
    public static final BiIntFunction mult=(x,y)->x*y;
    public static final BiIntFunction mult2=new BiIntFunction() {
        @Override
        public int apply(int x, int y) {
            return x*y;
        }
    };

    public static void main(String[] args) {
//        IntFunction f=new IntFunction() {
//            @Override
//            public int apply(int x) {
//                return 2*x;
//            }
//        };
//
//        System.out.println("f.apply(5) = " + f.apply(5));
//
//        IntFunction f2=x -> 2*x;
//        System.out.println("f2.apply(10) = " + f2.apply(10));
//
//        IntFunction f3 = (int x)->{
//
//            return x*2;
//        };
//        System.out.println("f3 = " + f3.apply(20));

        //x,y->x+y
//        BiIntFunction add=(x,y)->x+y;
//        System.out.println("add.apply(10,20) = " + add.apply(10, 20));
//
//        System.out.println("mult.apply(5,4) = " + mult.apply(5, 4));
//
//
//        System.out.println("add(x->x+2) = " + apply10(x -> x + 2));
//        System.out.println("add(x->x+2) = " + apply10(x -> 2*x + 2));
//
//        int priceAfterTax = applyPriceToOurSubscriptionService(
//                x -> x * (100 + 16) / 100);
//        System.out.println("priceAfterTax = " + priceAfterTax);
//        System.out.println(func().apply(20));
//
//        IntFunction f= x->x*x;
//
//        IntFunction g= x->2*x+1;
//
//        IntFunction fCompoG=f.compose(g);
//        IntFunction gCompoF=g.compose(f);
//
//        System.out.println(fCompoG.apply(4));
//        System.out.println("gCompoF.apply(4) = " + gCompoF.apply(4));

//        MyFunction<Integer,Integer> add5= x->x+5;
//        IntFunction add5Version2 = x->x+5;
//
//        System.out.println("add5.apply(10) = " + add5.apply(10));
//        System.out.println("add5Version2.apply(10) = " + add5Version2.apply(10));

        //(x,y)->x+y
        //x->y->x+y
//        BiIntFunction addUsingBi=(x,y)->x+y;
//
//        System.out.println("addUsingBi.apply(5,7) = "
//                + addUsingBi.apply(5, 7));
//
//        MyFunction<Integer,MyFunction<Integer,Integer>>
//                add=x->y->x+y;
//
//        System.out.println("add.apply(5).apply(7) = " +
//                add.apply(5).apply(7));
//
//        MyFunction<Integer, Integer> added5 = add.apply(5);
//        //added5: y->y+5
//        System.out.println("added5.apply(8) = " + added5.apply(8));
//        System.out.println("added5.apply(10) = " + added5.apply(10));

//        MyFunction<Integer,MyFunction<Integer,Integer>>
//                netPrice= tax->price->price*(100+tax)/100;
//        MyFunction<Integer,MyFunction<Integer,Integer>>
//                netPrice2=price->tax->netPrice.apply(tax).apply(price);
//
//        System.out.println("netPrice.apply(16).apply(100) = " + netPrice.apply(16).apply(100));
//        System.out.println("netPrice2.apply(100).apply(16) = " + netPrice2.apply(100).apply(16));

//
//        MyFunction<Integer, Integer> netPriceInJordan = netPrice.apply(16);//price->price(100+16)/100
//        MyFunction<Integer, Integer> netPriceInSA = netPrice.apply(2);

//        System.out.println("netPriceInJordan.apply(100) = " + netPriceInJordan.apply(100));
//
//        BiIntFunction netPriceV2=(tax,price)->price*(100+tax)/100;
//
//        System.out.println("netPriceV2.apply(16,100) = " + netPriceV2.apply(16, 100));
//        System.out.println("netPriceV2.apply(16,200) = " + netPriceV2.apply(16, 200));

//        System.out.println("calculateNetPrice(netPriceInJordan,\"1000230A\") = " + calculateNetPrice(netPriceInJordan, "1000230A"));
//
//        System.out.println("calculateNetPrice(netPriceInSA,\"1000230A\") = " + calculateNetPrice(netPriceInSA, "1000230A"));


//        BiIntFunction add=(x,y)->x+y;
//
//        MyFunction<Integer,MyFunction<Integer,Integer>> addV2= x->y->add.apply(x,y);
//
//        MyFunction<Integer, Integer> apply = addV2.apply(5);
//
//        MyFunction<Integer,MyFunction<Integer,Integer>> f1=x->y->x+y;
//        BiIntFunction f4=(x,y)->f1.apply(x).apply(y);

//        MyFunction<Integer,MyFunction<Integer,MyFunction<Integer,Integer>>>  add3= x->y->z->x+y+z;
//
//        System.out.println("add3.apply(1).apply(2).apply(3) = " + add3.apply(1).apply(2).apply(3));
//        MyFunction<Integer, MyFunction<Integer, Integer>> add2 = add3.apply(1);//y->z->1+y+z
//        MyFunction<Integer, Integer> apply = add2.apply(2);//z->1+2+z

//        Integer five=5;
//        MyFunction<Integer,Integer> add5= x->x+five;
//        five++;


        MyFunction<Integer,String> f=x->"The Result is: "+x;
        MyFunction<String,Integer> g= x->x.length();
        System.out.println("g.apply(\"Mohammad\") = " + g.apply("Mohammad"));
        System.out.println("f.apply(8) = " + f.apply(8));

        MyFunction<String, String> composed = f.compose(g);
        System.out.println("composed.apply(\"Mohammad\") = " + composed.apply("Mohammad"));
    }

    public static int calculateNetPrice(MyFunction<Integer, Integer> netPrice,String itemId){
        //from item id I can search my DB to get the price for the item..
        //then I will apply it to the equation to return the net price
        //all items have price 200
        return netPrice.apply(200);
    }

    public int apply10(int x, int y){
        return x+y;
    }

    public static int apply10(IntFunction func){
        return func.apply(10);
    }

    public static int applyPriceToOurSubscriptionService(
            IntFunction priceEquation){
        return priceEquation.apply(100);
    }

    public static IntFunction func(){
        return x->x+2;
    }





}

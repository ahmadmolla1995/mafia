package Exercise;

public class Sample {
    public static void main(String[] args) {
        Calculation calculationFirst = new Subtraction();
        int first = calculationFirst.calculate(10, 7);
        System.out.printf("Result is:%d\n", first);

        Calculation calculationSecond = new Addition();
        int second = calculationSecond.calculate(4, 8);
        System.out.printf("Result is:%d\n", second);

        Calculation calculationThird = new Multiplication();
        int third = calculationThird.calculate(7, 9);
        System.out.printf("Result is:%d", third);

        System.out.println("=========================================");
        Calculation addition = new Calculation() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        Calculation subtraction = new Calculation() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        };

        System.out.println(addition.calculate(7, 8));
        System.out.println(subtraction.calculate(17, 4));


        System.out.println("Lambda expressions");
        System.out.println("=====================================");

        Calculation lambdaAddition = (a, b) -> a + b;
        int firstResult = lambdaAddition.calculate(7, 15);
        Calculation lambdaSubtraction = (a, b) -> a - b;
        int secondResult = lambdaSubtraction.calculate(8, 2);
    }
}


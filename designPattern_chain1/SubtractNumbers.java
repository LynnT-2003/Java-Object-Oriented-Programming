package designPattern_chain1;

public class SubtractNumbers implements Chain{

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {

        System.out.println("Handler for subtraction called");

        if (request.getCalculationWanted()=="sub") {
            System.out.println(request.getNumber1() + "-" + request.getNumber2() +
                    " = " + (request.getNumber1() - request.getNumber2()));
        } else {
            System.out.println("   > Moving on to the next chain in sequence");
            nextInChain.calculate(request);
        }

    }
}

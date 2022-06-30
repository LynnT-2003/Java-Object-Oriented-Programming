package designPattern_chain2;

public class Dollar10_dispenser implements Chain {

    public Dollar10_dispenser() {

    }

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void dispense(Currency req_Amount) {
        if (req_Amount.getCurrency() == "USD") {
            if (req_Amount.getAmount() >= 10) {
                int count = req_Amount.getAmount() / 10;
                int remaining = req_Amount.getAmount() % 10;
                System.out.println("Dispensing " + count + " $10 note(s)");
                if (remaining != 0) {
                    System.out.println("    $" + remaining + " remaining");
                    System.out.println("    Next chain in sequence called");
                    this.nextInChain.dispense(new Currency(remaining, "USD"));
                } else {
                    System.out.println("    Successfully dispensed full amount\nEnd of line");
                }
            } else {
                System.out.println("    Next chain in sequence called");
                this.nextInChain.dispense(req_Amount);
            }
        }else {
            System.out.println("Sorry, this ATM only works for USD dollars");
        }
    }
}

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double applyDiscount(double total);
}

// Regular User (no discount)
class RegularUser extends User {
    public RegularUser(String name) {
        super(name);
    }

    @Override
    public double applyDiscount(double total) {
        return total; // No discount
    }
}

// Member User (gets a discount)
class MemberUser extends User {
    private static final double DISCOUNT_RATE = 0.10; // 10% membership discount

    public MemberUser(String name) {
        super(name);
    }

    @Override
    public double applyDiscount(double total) {
        System.out.println("Membership discount applied!");
        return total * (1 - DISCOUNT_RATE);
    }
}

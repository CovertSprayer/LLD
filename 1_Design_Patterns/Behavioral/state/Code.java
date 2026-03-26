interface MachineState {
    void selectItem(VendingMachine context, String itemCode);
    void insertCoin(VendingMachine context, double amount);
    void dispenseItem(VendingMachine context);
}

class IdleState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item selected: " + itemCode);
        context.setSelectedItem(itemCode);
        context.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please select an item before inserting coins");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Not item selected. Nothing to dispense");
    }
    
}

class ItemSelectedState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item selected: " + itemCode);
        context.setSelectedItem(itemCode);
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Inserted $" + amount + " for item: " + context.getSelectedItem());
        context.setAmount(amount);
        context.setState(new HasMoneyState());
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Please insert coin before dispensing");
    }
    
}

class HasMoneyState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Cannot change item after inserting money.");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Money already inserted.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Dispensing item: " + context.getSelectedItem());
        context.setState(new DispensingState());
        System.out.println("Item dispensed successfully.");
        context.resetMachine();
    }

    
}

class DispensingState implements MachineState {

    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Please waite, dispensing in progress");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please waite, dispensing in progress");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Please waite, dispensing in progress");
    }
    
}


class VendingMachine {
    private String selectedItem = "";
    private MachineState state;
    private double amount = 0.0;

    public VendingMachine() {
        this.state = new IdleState();
    }

    public void setSelectedItem(String itemCode) {
        this.selectedItem = itemCode;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void resetMachine() {
        this.selectedItem = "";
        this.amount = 0.0;
        this.state = new IdleState();
    }

    public void selectItem(String itemCode) {
        state.selectItem(this, itemCode);
    }

    public void insertCoin (double amount) {
        state.insertCoin(this, amount);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }
}

class Code{

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.insertCoin(1.0);
        vm.selectItem("A1");
        vm.insertCoin(1.5);
        vm.dispenseItem();

        System.out.println("\n ----- Second Txn ------");
        vm.selectItem("A5");
        vm.insertCoin(2.0);
        vm.dispenseItem();
    }
}
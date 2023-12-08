package com.ds.applicationforlearnig.incomes;

public class ShipsServiceIncome extends Income{
    private int shipsCount;

    public ShipsServiceIncome(int id, String name, int cost, int shipsCount) {
        super(id, name, cost);
        this.shipsCount = shipsCount;
    }

    public int getCostPerMonth(){
        return (getCost() * shipsCount);
    }
}

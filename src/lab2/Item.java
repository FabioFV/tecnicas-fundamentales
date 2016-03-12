package lab2;

public class Item {

    private String mName;
    private String mType;
    private double mCost;

    public Item(String name, String type, double cost) {
        mName = name;
        mType = type;
        mCost = cost;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public double getCost() {
        return mCost;
    }

    public double calculateShippingRate()
    {
        if(mType.equals("Book"))
            return 0.0;
        else
        {
            if(mCost > 100.0)
                return 5.0;
            else
                return mCost * 0.05;
        }
    }
}

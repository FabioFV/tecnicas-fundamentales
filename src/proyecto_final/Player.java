package proyecto_final;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Player {

    private String mName;
    private String mLastName;
    private String mHanded;

    public Player(String name, String lastName, String handed)
    {
        mName = name;
        mLastName = lastName;
        mHanded = handed;
    }
    public void setName(String name){
        mName = name;
    }
    public void setLastName(String lastName){
        mLastName = lastName;
    }
    public void setHanded(String handed){
        mHanded = handed;
    }
    public String getName()
    {
        return mName;
    }
    public String getLastName()
    {
        return mLastName;
    }
    public String getHanded()
    {
        return mHanded;
    }
    @Override
    public String toString() {
        return null;
    }
    
}

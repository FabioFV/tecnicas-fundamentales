/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366], Jorge Contin [1057170]
 */

package proyecto_medio_termino;

public class Player {
    private String mName;
    private String mLastName;
    private String mHanded;

    public Player(String name, String lastname, String handed){
        mName = name;
        mLastName = lastname;
        mHanded = handed;
    }

    public String getName(){
        return mName;
    }

    public String getLastName(){
        return mLastName;
    }

    public String getHanded(){
        return mHanded;
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName();
    }
}

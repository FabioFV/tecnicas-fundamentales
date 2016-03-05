/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

public enum Shots {

    SERVE, FOREHAND, BACKHAND, VOLLEY, LOB, DROPSHOT, SMASH, TWEENER, SLICE;

    @Override
    public String toString() {
        switch (this)
        {
            case SERVE:
                return "Servicio";
            case FOREHAND:
                return "Derecha";
            case BACKHAND:
                return "Reves";
            case VOLLEY:
                return "Volea";
            case LOB:
                return "Globo";
            case DROPSHOT:
                return "Dejada";
            case SMASH:
                return "Remate";
            case TWEENER:
                return "Tweener";
            case SLICE:
                return "Slice";
            default:
                throw new IllegalArgumentException();
        }
    }
}

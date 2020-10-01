package interfaces;

import unidades.Bateria;
import unidades.MuroEnergia;
import unidades.NaveInvasora;


public interface Impacto {

    /**
     * @param NaveInvasora 
     * @return
     */
    public boolean proyectilHitNave(NaveInvasora nave);

    /**
     * @param Player 
     * @return
     */
    public boolean proyectilHitPlayer(Bateria bateria);

    /**
     * @param MuroEnergia 
     * @return
     */
    public boolean proyectilHitMuroEnergia(MuroEnergia muro);

}
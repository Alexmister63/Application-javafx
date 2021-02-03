package manager.movement;

import entity.view_entity.ViewPlayerCharactere;

import java.util.List;

public class MoveManager {



    public void move(List<CanMove> lcc){
        for(CanMove cm : lcc)
        cm.move();
    }
}

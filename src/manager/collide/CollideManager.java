package manager.collide;

import Main.GameEnvironement;
import entity.Faces;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class CollideManager {


    public void testCollide(List<CanCollide> element) {
        for (CanCollide cp : element) {
            for (CanCollide cs : element)
                if (!cp.equals(cs) && cp.getHitbox().getBoundsInParent().intersects(cs.getHitbox().getLayoutBounds()))
                    cp.whenCollide(cs.onTouch());
        }
    }


    public List<Faces> testAreaCollide(CanCollide cc) {
        List<Faces> faces = new ArrayList<>();
        if (cc.getHitbox().getLayoutX() <= 0) {
            faces.add(Faces.LEFT);
        }
        if (cc.getHitbox().getLayoutX() >= GameEnvironement.getGameEnvironement().getGameArea().getPrefWidth()) {
            faces.add(Faces.RIGHT);
        }
        if (cc.getHitbox().getLayoutY() <= 0) {
            faces.add(Faces.UP);
        }
        if (cc.getHitbox().getLayoutX() >= GameEnvironement.getGameEnvironement().getGameArea().getPrefWidth())
            faces.add(Faces.DOWN);
        return faces;

    }
}

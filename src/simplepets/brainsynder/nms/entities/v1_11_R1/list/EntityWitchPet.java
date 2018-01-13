package simplepets.brainsynder.nms.entities.v1_11_R1.list;

import net.minecraft.server.v1_11_R1.World;
import simplepets.brainsynder.api.entity.hostile.IEntityWitchPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_11_R1.EntityPet;

public class EntityWitchPet extends EntityPet implements IEntityWitchPet {

    public EntityWitchPet(World world) {
        super(world);
    }

    public EntityWitchPet(World world, IPet pet) {
        super(world, pet);
    }

}

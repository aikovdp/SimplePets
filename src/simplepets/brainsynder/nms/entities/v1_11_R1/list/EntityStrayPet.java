package simplepets.brainsynder.nms.entities.v1_11_R1.list;

import net.minecraft.server.v1_11_R1.World;
import simplepets.brainsynder.api.entity.hostile.IEntityStrayPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_11_R1.branch.EntitySkeletonAbstractPet;

public class EntityStrayPet extends EntitySkeletonAbstractPet implements IEntityStrayPet {
    public EntityStrayPet(World world, IPet pet) {
        super(world, pet);
    }

    public EntityStrayPet(World world) {
        super(world);
    }
}

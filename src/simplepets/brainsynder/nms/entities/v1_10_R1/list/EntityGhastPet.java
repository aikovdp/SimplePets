package simplepets.brainsynder.nms.entities.v1_10_R1.list;

import net.minecraft.server.v1_10_R1.DataWatcher;
import net.minecraft.server.v1_10_R1.DataWatcherObject;
import net.minecraft.server.v1_10_R1.DataWatcherRegistry;
import net.minecraft.server.v1_10_R1.World;
import simplepets.brainsynder.api.entity.IFlyablePet;
import simplepets.brainsynder.api.entity.hostile.IEntityGhastPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_10_R1.EntityPet;

/**
 * @Deprecated Will be removed when MC version 1.13 is released
 */
@Deprecated
public class EntityGhastPet extends EntityPet implements IEntityGhastPet,
        IFlyablePet {
    private static final DataWatcherObject<Boolean> a;

    static {
        a = DataWatcher.a(EntityGhastPet.class, DataWatcherRegistry.h);
    }

    public EntityGhastPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    protected void initDataWatcher() {
        super.initDataWatcher();
        this.datawatcher.register(a, Boolean.valueOf(false));
    }
}

package simplepets.brainsynder.nms.v1_13_R1.entities.list;

import net.minecraft.server.v1_13_R1.DataWatcher;
import net.minecraft.server.v1_13_R1.DataWatcherObject;
import net.minecraft.server.v1_13_R1.EntityTypes;
import net.minecraft.server.v1_13_R1.World;
import simple.brainsynder.nbt.StorageTagCompound;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.hostile.IEntityGuardianPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.v1_13_R1.entities.EntityPet;
import simplepets.brainsynder.nms.v1_13_R1.registry.Types;
import simplepets.brainsynder.nms.v1_13_R1.utils.DataWatcherWrapper;

@Size(width = 0.85F, length = 0.85F)
public class EntityGuardianPet extends EntityPet implements IEntityGuardianPet {
    private static final DataWatcherObject<Boolean> MOVING;
    private static final DataWatcherObject<Integer> TARGET_ENTITY;

    static {
        MOVING = DataWatcher.a(EntityGuardianPet.class, DataWatcherWrapper.BOOLEAN);
        TARGET_ENTITY = DataWatcher.a(EntityGuardianPet.class, DataWatcherWrapper.INT);
    }

    public EntityGuardianPet(World world) {
        super(Types.GUARDIAN, world);
    }
    public EntityGuardianPet(World world, IPet pet) {
        super(Types.GUARDIAN, world, pet);
    }
    public EntityGuardianPet(EntityTypes<?> type, World world) {
        super(type, world);
    }
    public EntityGuardianPet(EntityTypes<?> type, World world, IPet pet) {
        super(type, world, pet);
    }

    @Override
    protected void registerDatawatchers() {
        super.registerDatawatchers();
        this.datawatcher.register(MOVING, Boolean.FALSE);
        this.datawatcher.register(TARGET_ENTITY, 0);
    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setBoolean("elder", isElder());
        return object;
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("elder")) setElder(object.getBoolean("elder"));
        super.applyCompound(object);
    }
}

package simplepets.brainsynder.nms.v1_13_R1.entities.list;

import net.minecraft.server.v1_13_R1.DataWatcher;
import net.minecraft.server.v1_13_R1.DataWatcherObject;
import net.minecraft.server.v1_13_R1.World;
import simple.brainsynder.nbt.StorageTagCompound;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.hostile.IEntityCreeperPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.v1_13_R1.entities.EntityPet;
import simplepets.brainsynder.nms.v1_13_R1.registry.Types;
import simplepets.brainsynder.nms.v1_13_R1.utils.DataWatcherWrapper;

@Size(width = 0.6F, length = 1.9F)
public class EntityCreeperPet extends EntityPet implements IEntityCreeperPet {
    protected static final DataWatcherObject<Integer> STATE;
    protected static final DataWatcherObject<Boolean> POWERED;
    protected static final DataWatcherObject<Boolean> IGNITED;

    static {
        STATE = DataWatcher.a(EntityCreeperPet.class, DataWatcherWrapper.INT);
        POWERED = DataWatcher.a(EntityCreeperPet.class, DataWatcherWrapper.BOOLEAN);
        IGNITED = DataWatcher.a(EntityCreeperPet.class, DataWatcherWrapper.BOOLEAN);
    }

    public EntityCreeperPet(World world) {
        super(Types.CREEPER, world);
    }

    public EntityCreeperPet(World world, IPet pet) {
        super(Types.CREEPER, world, pet);
    }

    @Override
    protected void registerDatawatchers() {
        super.registerDatawatchers();
        this.datawatcher.register(STATE, -1);
        this.datawatcher.register(POWERED, false);
        this.datawatcher.register(IGNITED, false);
    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setBoolean("powered", isPowered());
        return object;
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("powered")) setPowered(object.getBoolean("powered"));
        super.applyCompound(object);
    }

    @Override
    public boolean isIgnited() {
        return datawatcher.get(IGNITED);
    }

    @Override
    public void setIgnited(boolean flag) {
        this.datawatcher.set(IGNITED, flag);
    }

    @Override
    public boolean isPowered() {
        return datawatcher.get(POWERED);
    }

    @Override
    public void setPowered(boolean flag) {
        this.datawatcher.set(POWERED, flag);
    }
}

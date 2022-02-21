package simplepets.brainsynder.nms;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;

public class VersionTranslator {
    public static final String ENTITY_DATA_MAP = "f";
    public static final String ENTITY_FACTORY_FIELD = "bm";

    public static <T extends Entity> T getEntityHandle(org.bukkit.entity.Entity entity) {
        return (T) ((CraftEntity)entity).getHandle();
    }

    public static <T extends Level> T getWorldHandle(World world) {
        return (T) ((CraftWorld)world).getHandle();
    }

    public static BlockState getBlockState(BlockData blockData) {
        return ((CraftBlockData)blockData).getState();
    }

    public static BlockData fromNMS(BlockState blockData) {
        return CraftBlockData.fromData(blockData);
    }

    public static ItemStack toNMSStack(org.bukkit.inventory.ItemStack itemStack) {
        return CraftItemStack.asNMSCopy(itemStack);
    }

    public static org.bukkit.inventory.ItemStack toBukkit(ItemStack itemStack) {
        return CraftItemStack.asBukkitCopy(itemStack);
    }
}
package simplepets.brainsynder.menu.menuItems.base;

import org.bukkit.entity.Player;
import simple.brainsynder.api.ItemMaker;
import simplepets.brainsynder.PetCore;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.pet.PetDefault;
import simplepets.brainsynder.reflection.ReflectionUtil;

public abstract class MenuItem {
    protected IEntityPet entityPet;
    protected PetDefault type;

    MenuItem(PetDefault type, IEntityPet entityPet) {
        this.entityPet = entityPet;
        this.type = type;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public int getVersion() {
        return 18;
    }

    public boolean isSupported() {
        return (ReflectionUtil.getVersionInt() >= getVersion());
    }

    public IEntityPet getEntityPet() {
        return entityPet;
    }

    public abstract ItemMaker getItem();

    public String getPermission() {
        return (type.getPermission() + '.' + getClass().getSimpleName().toLowerCase());
    }

    public boolean hasPermission(Player player) {
        if (!PetCore.get().getConfiguration().getBoolean("Needs-Permission")) return true;
        if (!PetCore.get().getConfiguration().getBoolean("Needs-Data-Permissions")) return true;
        return player.hasPermission(type.getPermission() + ".*") || (player.hasPermission(getPermission()));
    }
}

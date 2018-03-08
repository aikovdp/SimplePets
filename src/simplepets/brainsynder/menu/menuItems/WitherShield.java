package simplepets.brainsynder.menu.menuItems;

import org.bukkit.Material;
import simple.brainsynder.api.ItemMaker;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.hostile.IEntityWitherPet;
import simplepets.brainsynder.menu.menuItems.base.MenuItemAbstract;
import simplepets.brainsynder.pet.PetDefault;

public class WitherShield extends MenuItemAbstract {
    private ItemMaker item = new ItemMaker(Material.NETHER_STAR);

    public WitherShield(PetDefault type, IEntityPet entityPet) {
        super(type, entityPet);
    }

    @Override
    public ItemMaker getItem() {
        if (entityPet instanceof IEntityWitherPet) {
            IEntityWitherPet var = (IEntityWitherPet) entityPet;
            item.setName("&6Shielded: &e" + var.isShielded());
        }
        return item;
    }

    @Override
    public void onLeftClick() {
        if (entityPet instanceof IEntityWitherPet) {
            IEntityWitherPet pet = (IEntityWitherPet) entityPet;
            if (pet.isShielded()) {
                pet.setShielded(false);
            } else {
                pet.setShielded(true);
            }
        }
    }
}

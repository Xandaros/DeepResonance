package mcjty.deepresonance;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcjty.base.ModBase;
import mcjty.deepresonance.blocks.ModBlocks;
import mcjty.deepresonance.compat.CompatHandler;
import mcjty.deepresonance.compat.handlers.ComputerCraftCompatHandler;
import mcjty.deepresonance.grid.WorldGridRegistry;
import mcjty.deepresonance.proxy.CommonProxy;
import mcjty.gui.GuiStyle;
import mcjty.varia.Logging;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Logger;

@Mod(modid = DeepResonance.MODID, name="DeepResonance", dependencies =
        "required-after:Forge@["+DeepResonance.MIN_FORGE_VER+
        ",);required-after:McJtyLib@["+DeepResonance.MIN_MCJTYLIB_VER+
        ",);required-after:ElecCore@["+DeepResonance.MIN_ELECCORE_VER+
        ",)",
        version = DeepResonance.VERSION)
public class DeepResonance implements ModBase {
    public static final String MODID = "deepresonance";
    public static final String VERSION = "0.1.1";
    public static final String MIN_FORGE_VER = "10.13.2.1291";
    public static final String MIN_MCJTYLIB_VER = "1.3.0";
    public static final String MIN_ELECCORE_VER = "1.4.122";

    @SidedProxy(clientSide="mcjty.deepresonance.proxy.ClientProxy", serverSide="mcjty.deepresonance.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance("deepresonance")
    public static DeepResonance instance;
    public static WorldGridRegistry worldGridRegistry;
    public static CompatHandler compatHandler;
    public static Logger logger;

    public static final String SHIFT_MESSAGE = "<Press Shift>";

    /** This is used to keep track of GUIs that we make*/
    private static int modGuiIndex = 0;

    public static final int GUI_MANUAL_MAIN = modGuiIndex++;

    public static CreativeTabs tabDeepResonance = new CreativeTabs("DeepResonance") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.resonatingCrystalBlock);
        }
    };

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and
     * register them with the GameRegistry.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
        logger = e.getModLog();
        worldGridRegistry = new WorldGridRegistry();
        compatHandler = new CompatHandler(proxy.mainConfig, logger);
        compatHandler.addHandler(new ComputerCraftCompatHandler());
        FMLInterModComms.sendMessage("Waila", "register", "mcjty.wailasupport.WailaCompatibility.load");
        FMLInterModComms.sendMessage("rftools", "dimlet_configure", "Material.tile.oreResonating=30000,6000,400,5");
//        mainConfigDir = e.getModConfigurationDirectory();
//        mainConfig = new Configuration(new File(mainConfigDir.getPath() + File.separator + "rftools", "main.cfg"));
//
//        readMainConfig();
//
//        PacketHandler.registerMessages("rftools");
//        RFToolsMessages.registerNetworkMessages();
//
    }



    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        compatHandler.init();
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {
        Logging.log("Deep Resonance: server is stopping. Shutting down gracefully");
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Override
    public String getModId() {
        return MODID;
    }

    @Override
    public void setGuiStyle(EntityPlayerMP entityPlayerMP, GuiStyle guiStyle) {

    }

    @Override
    public GuiStyle getGuiStyle(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public void openManual(EntityPlayer entityPlayer, int i, String s) {

    }
}

package net.minecraft.src.absorr.morecrafts;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.absorr.morecrafts.InversionRecipes;

public class InversionRecipes
{
	private static final InversionRecipes smeltingBase = new InversionRecipes();
	static Map smeltMap = FurnaceRecipes.smelting().getSmeltingList();
	static Map reverseList = new HashMap();
	public InversionRecipes() 
    { 
		
    }
	public static String loader()
	{
		for (Object o : smeltMap.keySet()) 
        {
        	ItemStack x = (ItemStack) smeltMap.get(o);
        	addSmelting((Integer) o, x);
        }
		return "it";
	}
	public static void addSmelting(int par1, ItemStack par2ItemStack)
    {
        reverseList.put(par2ItemStack.itemID, Integer.valueOf(par1));
    }
	public static final InversionRecipes smelting()
	{
		return smeltingBase;
	}
	
	public Map getSmeltingList()
    {
        return this.reverseList;
    }
	public int getInversionResultID(ItemStack i)
	{
		Object inversed = InversionRecipes.smelting().getSmeltingList().get(i.itemID);
		Integer inv = new Integer(inversed.toString());
		return inv;
	}
	public ItemStack getInversionResult(ItemStack i)
	{
		Object inversed = InversionRecipes.smelting().getSmeltingList().get(i.itemID);
		Integer inv = new Integer(inversed.toString());
		return new ItemStack(inv, 1, 0);
	}
	public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
          if (hm.get(o).equals(value)) {
            return o;
          }
        }
        return null;
    }
}
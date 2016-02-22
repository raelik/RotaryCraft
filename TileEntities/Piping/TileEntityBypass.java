/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.TileEntities.Piping;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import Reika.RotaryCraft.Base.TileEntity.TileEntityPiping;
import Reika.RotaryCraft.Registry.MachineRegistry;

public class TileEntityBypass extends TileEntityPiping {

	private Fluid fluid;
	private int level;

	@Override
	public boolean canConnectToPipe(MachineRegistry m) {
		return m.isStandardPipe() || m == MachineRegistry.FUELLINE;
	}

	@Override
	public IIcon getBlockIcon() {
		return Blocks.sandstone.getIcon(1, 0);
	}

	@Override
	public boolean hasLiquid() {
		return level > 0;
	}

	@Override
	public Fluid getFluidType() {
		return fluid;
	}

	@Override
	public MachineRegistry getMachine() {
		return MachineRegistry.BYPASS;
	}

	@Override
	public int getFluidLevel() {
		return level;
	}

	@Override
	protected void setFluid(Fluid f) {
		fluid = f;
	}

	@Override
	protected void setLevel(int amt) {
		level = amt;
	}

	@Override
	protected boolean interactsWithMachines() {
		return false;
	}

	@Override
	protected void onIntake(TileEntity te) {

	}

	@Override
	public boolean isValidFluid(Fluid f) {
		return true;
	}

	@Override
	public boolean canReceiveFromPipeOn(ForgeDirection side) {
		return true;
	}

	@Override
	public boolean canEmitToPipeOn(ForgeDirection side) {
		return true;
	}

	@Override
	public Block getPipeBlockType() {
		return Blocks.sandstone;
	}

	@Override
	public boolean canIntakeFromIFluidHandler(ForgeDirection side) {
		return false;
	}

	@Override
	public boolean canOutputToIFluidHandler(ForgeDirection side) {
		return false;
	}

}

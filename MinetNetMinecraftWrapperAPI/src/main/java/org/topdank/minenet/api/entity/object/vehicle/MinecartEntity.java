package org.topdank.minenet.api.entity.object.vehicle;

import java.util.Map;

import org.topdank.minenet.api.world.World;

public class MinecartEntity extends VehicleEntity {
	
	protected int shakingPower;
	protected int shakeDirection;
	protected int carriedBlockId;
	protected int carriedBlockData;
	protected int carriedBlockYPos;
	protected boolean showCarriedBlock;
	
	public MinecartEntity(World world, int id) {
		super(world, id, 0.98F, 0.7F);
	}
	
	public int getShakingPower() {
		return shakingPower;
	}
	
	public void setShakingPower(int shakingPower) {
		this.shakingPower = shakingPower;
	}
	
	public int getShakeDirection() {
		return shakeDirection;
	}
	
	public void setShakeDirection(int shakeDirection) {
		this.shakeDirection = shakeDirection;
	}
	
	public int getCarriedBlockId() {
		return carriedBlockId;
	}
	
	public void setCarriedBlockId(int carriedBlockId) {
		this.carriedBlockId = carriedBlockId;
	}
	
	public int getCarriedBlockData() {
		return carriedBlockData;
	}
	
	public void setCarriedBlockData(int carriedBlockData) {
		this.carriedBlockData = carriedBlockData;
	}
	
	public int getCarriedBlockYPos() {
		return carriedBlockYPos;
	}
	
	public void setCarriedBlockYPos(int carriedBlockYPos) {
		this.carriedBlockYPos = carriedBlockYPos;
	}
	
	public boolean isShowCarriedBlock() {
		return showCarriedBlock;
	}
	
	public void setShowCarriedBlock(boolean showCarriedBlock) {
		this.showCarriedBlock = showCarriedBlock;
	}
	
	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		
		if (metadata.containsKey(17)) {
			setShakingPower((int) metadata.get(17));
		}
		
		if (metadata.containsKey(18)) {
			setShakeDirection((int) metadata.get(18));
		}
		
		if (metadata.containsKey(19)) {
			setDamageTaken((int) metadata.get(19));
		}
		
		if (metadata.containsKey(20)) {
			int flags = (int) metadata.get(20);
			setCarriedBlockId(flags & 0x00FF);
			setCarriedBlockId(flags & 0xFF00);
		}
		
		if (metadata.containsKey(21)) {
			setCarriedBlockYPos((int) metadata.get(21));
		}
		
		if (metadata.containsKey(22)) {
			setShowCarriedBlock((byte) metadata.get(22) != 0);
		}
	}
}
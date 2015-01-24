package org.topdank.minenet.api.entity.living.monsters;

import java.util.Map;

import org.topdank.minenet.api.entity.living.LivingEntity;
import org.topdank.minenet.api.world.World;

public class ZombieEntity extends LivingEntity {
	
	private boolean isChild;
	private boolean isVillager;
	private boolean isConverting;
	
	public ZombieEntity(World world, int id) {
		super(world, id, 0.6F, 1.95F);
	}
	
	public ZombieEntity(World world, int id, float scale) {
		super(world, id, 0.6F * scale, 1.95F * scale);
	}
	
	public boolean isChild() {
		return isChild;
	}
	
	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}
	
	public boolean isVillager() {
		return isVillager;
	}
	
	public void setVillager(boolean isVillager) {
		this.isVillager = isVillager;
	}
	
	public boolean isConverting() {
		return isConverting;
	}
	
	public void setConverting(boolean isConverting) {
		this.isConverting = isConverting;
	}
	
	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);
		
		if (metadata.containsKey(12)) {
			setChild((byte) metadata.get(12) != 0);
		}
		
		if (metadata.containsKey(13)) {
			setVillager((byte) metadata.get(13) != 0);
		}
		
		if (metadata.containsKey(14)) {
			setConverting((byte) metadata.get(14) != 0);
		}
	}
}
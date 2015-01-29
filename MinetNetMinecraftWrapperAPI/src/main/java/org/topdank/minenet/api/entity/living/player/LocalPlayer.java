package org.topdank.minenet.api.entity.living.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.topdank.minenet.api.BotContext;
import org.topdank.minenet.api.entity.Entity;
import org.topdank.minenet.api.event.entity.EntityHitEvent;
import org.topdank.minenet.api.event.entity.EntityUseEvent;
import org.topdank.minenet.api.event.player.ArmSwingEvent;
import org.topdank.minenet.api.event.player.RequestRespawnEvent;
import org.topdank.minenet.api.game.BoundingBox;
import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.PreciseLocation;
import org.topdank.minenet.api.item.Inventory;
import org.topdank.minenet.api.item.ItemStack;
import org.topdank.minenet.api.item.PlayerInventory;
import org.topdank.minenet.api.item.ToolType;
import org.topdank.minenet.api.util.MathHelper;
import org.topdank.minenet.api.world.block.Block;
import org.topdank.minenet.api.world.block.BlockType;

import eu.bibl.eventbus.EventBus;

public class LocalPlayer extends PlayerEntity {

	protected BotContext context;
	protected EventBus bus;

	private PlayerController controller;

	private PlayerInventory inventory;
	private Inventory window;

	private int hunger;
	private float foodSaturation;

	private int experienceLevel, experienceTotal;
	private double lastX, lastY, lastZ, lastYaw, lastPitch;

	public LocalPlayer(BotContext context, int id, String name) {
		super(context.getWorld(), id, name, context.getWorld().getSettings().getGameMode());
		this.context = context;
		bus = context.getEventBus();
		controller = context.getVersionProvider().getPlayerController();
		inventory = new PlayerInventory(context, this);
	}

	public void updateGravity() {
		double dist = distanceToGround();
		// BoundingBox bb = getBoundingBox();
		// boolean inWater = world.isInMaterial(bb, BlockType.WATER,
		// BlockType.STATIONARY_WATER);
		// boolean inLava = world.isInMaterial(bb, BlockType.LAVA,
		// BlockType.STATIONARY_LAVA);
		// double horizFactor = 0.91;
		if (dist <= 0.08) {
			// BlockType type = BlockType.getById(world.getBlockIdAt((int)
			// Math.floor(x), (int) Math.floor(y - 0.1),
			// (int) Math.floor(z)));
			// if (type.isSolid())
			// horizFactor *= friction; 1F atm
			motY = 0;
		} else {
			if (motY > 3.92)
				motY -= 0.08;
		}
		// } else if (!inWater && !inLava)
		// accelerate(0, -Math.PI / 2, 0.08, 3.92);

		// motX *= horizFactor;
		// motZ *= horizFactor;
		//
		// x += motX;
		// y += motY;
		// z += motZ;

		// motX *= horizFactor;
		// motY *= 0.98;
		// motZ *= horizFactor;
		// if (inLava) {
		// motX *= 0.5D;
		// motY *= 0.5D;
		// motZ *= 0.5D;
		// motY -= 0.02D;
		// } else if (inWater) {
		// motX *= 0.800000011920929D;
		// motY *= 0.800000011920929D;
		// motZ *= 0.800000011920929D;
		// motY -= 0.02D;
		// }
		//
		// handleCollision();
		//
		// if (motX >= -1E-6 && motX <= 1E-6)
		// motX = 0;
		// if (motY >= -1E-6 && motY <= 1E-6)
		// motY = 0;
		// if (motZ >= -1E-6 && motZ <= 1E-6)
		// motZ = 0;
		// x += motX;
		// y += motY;
		// z += motZ;
	}

	public void handleCollision() {
		BoundingBox bounds = getBoundingBox();
		Set<Block> currentCollisions = world.getCollidingBlocks(bounds);
		final double off = 0.01;
		double velocity = 0;
		for (double v = 0, target = Math.abs(motX), sign = Math.signum(motX); (v < (target + off)) && !collides(bounds.offset(sign * v, 0, 0), currentCollisions); v += off)
			velocity = sign * Math.min(v, target);
		motX = velocity;
		velocity = 0;
		for (double v = 0, target = Math.abs(motZ), sign = Math.signum(motZ); (v < (target + off)) && !collides(bounds.offset(0, 0, sign * v), currentCollisions); v += off)
			velocity = sign * Math.min(v, target);
		motZ = velocity;
		velocity = 0;
		for (double v = 0, target = Math.abs(motY), sign = Math.signum(motY); (v < (target + off)) && !collides(bounds.offset(0, sign * v, 0), currentCollisions); v += off)
			velocity = sign * Math.min(v, target);
		motY = velocity;
		if (collides(bounds.offset(motX, 0, 0), currentCollisions))
			motX = 0;
		if (collides(bounds.offset(0, 0, motZ), currentCollisions))
			motZ = 0;
		if (collides(bounds.offset(0, motY, 0), currentCollisions))
			motY = 0;
		if (collides(bounds.offset(motX, motY, motZ), currentCollisions))
			motX = motY = motZ = 0;
	}

	private boolean collides(BoundingBox bounds, Set<Block> ignore) {
		Set<Block> found = world.getCollidingBlocks(bounds);
		found.removeAll(ignore);
		return !found.isEmpty();
	}

	public double distanceToGround() {
		int standingOnY = (int) Math.floor(y);

		int groundY = distToGround(x, standingOnY, z);
		groundY = Math.max(groundY, distToGround(x + 0.3, standingOnY, z + 0.3));
		groundY = Math.max(groundY, distToGround(x + 0.3, standingOnY, z - 0.3));
		groundY = Math.max(groundY, distToGround(x - 0.3, standingOnY, z + 0.3));
		groundY = Math.max(groundY, distToGround(x - 0.3, standingOnY, z - 0.3));

		return y - groundY;
	}

	public int distToGround(double dx, int y, double dz) {
		int x = (int) Math.floor(dx), z = (int) Math.floor(dz);
		while (y > 0) {
			int id = world.getBlockData(new BlockLocation(x, (y - 1), z));
			BlockType type = BlockType.getById(id);
			if (type.isSolid())
				break;
			y--;
		}
		return y;
	}

	public List<BlockLocation> getBlocksStoodOn() {
		// TODO: write a proper algorithm, update: nvm

		// cache results (faster?) yes
		// if ((x == lastX) && (y == lastY) && (z == lastZ)) {
		// return cache;
		// }
		List<BlockLocation> locs = new ArrayList<BlockLocation>();

		double x = this.x;
		double y = this.y - 1;
		double z = this.z;
		BlockLocation thisLocation = new BlockLocation(x, y, z);
		// possible offsets for +ve/-ve locations
		BlockLocation block1 = new BlockLocation(x + 0.3D, y, z + 0.3D);
		BlockLocation block2 = new BlockLocation(x - 0.3D, y, z + 0.3D);
		BlockLocation block3 = new BlockLocation(x + 0.3D, y, z - 0.3D);
		BlockLocation block4 = new BlockLocation(x - 0.3D, y, z - 0.3D);

		// cache never reaches 5 (shouldn't :|)
		if (!locs.contains(thisLocation) && BlockType.getById(world.getBlockData(new BlockLocation(thisLocation.getX(), thisLocation.getY(), thisLocation.getZ()))).isSolid())
			locs.add(thisLocation);

		if (!locs.contains(block1) && BlockType.getById(world.getBlockData(new BlockLocation(block1.getX(), block1.getY(), block1.getZ()))).isSolid())
			locs.add(block1);
		if (!locs.contains(block2) && BlockType.getById(world.getBlockData(new BlockLocation(block2.getX(), block2.getY(), block2.getZ()))).isSolid())
			locs.add(block2);
		if (!locs.contains(block3) && BlockType.getById(world.getBlockData(new BlockLocation(block3.getX(), block3.getY(), block3.getZ()))).isSolid())
			locs.add(block3);
		if (!locs.contains(block4) && BlockType.getById(world.getBlockData(new BlockLocation(block4.getX(), block4.getY(), block4.getZ()))).isSolid())
			locs.add(block4);

		// System.out.println("on " + locs.size() + " blocks.");
		// for (BlockLocation loc : locs) {
		// System.out.println(loc);
		// }

		return locs;
	}

	@Deprecated
	public double distToGround() {
		// if ((x == lastX) && (y == lastY) && (z == lastZ)) {
		// return lastDist;
		// }

		// TODO: optimise by checking if only y changed and --ing it?

		double smallest = 256;// TODO: fix, bit unsafe, don't want it to jump
								// 256 blocks
		List<BlockLocation> locs = getBlocksStoodOn();
		// System.out.println("Entering " + cache.size());
		if (locs.size() > 0) {
			for (BlockLocation loc : locs) {
				int currentY = (int) Math.floor(loc.getY());
				int x = (int) Math.floor(loc.getX());
				int z = (int) Math.floor(loc.getZ());
				while (currentY > 0) {
					int id = world.getBlockData(new BlockLocation(x, currentY, z));
					BlockType type = BlockType.getById(id);
					if (type.isSolid()) {
						double d = (y - currentY) - 1;
						if (d < smallest) {
							smallest = d;
							// System.out.println("    Smallest: " + smallest);
						}
						break;
					}
					currentY--;
				}
			}
		} else {
			int currentY = (int) Math.floor(y);
			int x = (int) Math.floor(this.x);
			int z = (int) Math.floor(this.z);
			while (currentY > 0) {
				int id = world.getBlockData(new BlockLocation(x, currentY, z));
				BlockType type = BlockType.getById(id);
				if (type.isSolid()) {
					double d = (y - currentY) - 1;
					if (d < smallest) {
						smallest = d;
						// System.out.println("    Smallest: " + smallest);
					}
					break;
				}
				currentY--;
			}
		}

		// System.out.println("Returning with " + smallest);
		return smallest;
	}

	private void resetMotion() {
		motX = 0;
		motY = 0;
		motZ = 0;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		resetMotion();
	}

	@Override
	public void setY(double y) {
		this.y = y;
		resetMotion();
	}

	@Override
	public void setZ(double z) {
		this.z = z;
		resetMotion();
	}

	@Override
	public void setLocation(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		resetMotion();
	}

	@Override
	public void setLocation(BlockLocation loc) {
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
		resetMotion();
	}

	@Override
	public void setLocation(PreciseLocation loc) {
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
		resetMotion();
	}

	@Override
	public void setHealth(float health) {
		this.health = health;
		System.out.println("set health: " + health);
		if (health <= 0) {
			bus.dispatch(new RequestRespawnEvent());
		}
	}

	public PlayerInventory getInventory() {
		return inventory;
	}

	public void setInventory(PlayerInventory inventory) {
		this.inventory = inventory;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public float getFoodSaturation() {
		return foodSaturation;
	}

	public void setFoodSaturation(float foodSaturation) {
		this.foodSaturation = foodSaturation;
	}

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public int getExperienceTotal() {
		return experienceTotal;
	}

	public void setExperienceTotal(int experienceTotal) {
		this.experienceTotal = experienceTotal;
	}

	public Inventory getWindow() {
		return window;
	}

	public void setWindow(Inventory window) {
		this.window = window;
	}

	public double getLastX() {
		return lastX;
	}

	public void setLastX(double lastX) {
		this.lastX = lastX;
	}

	public double getLastY() {
		return lastY;
	}

	public void setLastY(double lastY) {
		this.lastY = lastY;
	}

	public double getLastZ() {
		return lastZ;
	}

	public void setLastZ(double lastZ) {
		this.lastZ = lastZ;
	}

	public double getLastYaw() {
		return lastYaw;
	}

	public void setLastYaw(double lastYaw) {
		this.lastYaw = lastYaw;
	}

	public double getLastPitch() {
		return lastPitch;
	}

	public void setLastPitch(double lastPitch) {
		this.lastPitch = lastPitch;
	}

	public void closeWindow() {
		if (window != null) {
			window.close();
			window = null;
		}
	}

	public void face(BlockLocation target) {
		face(target.getX() + 0.5, target.getY() + 0.5, target.getZ() + 0.5);
	}

	public void face(BlockLocation target, int face) {
		BlockLocation offset = getOffsetBlock(target, face);
		if (offset == null) {
			face(target);
			return;
		}
		double x = offset.getX() + ((target.getX() - offset.getX()) / 2.0D) + 0.5;
		double y = offset.getY() + ((target.getY() - offset.getY()) / 2.0D);
		double z = offset.getZ() + ((target.getZ() - offset.getZ()) / 2.0D) + 0.5;
		face(x, y, z);
	}

	private BlockLocation getOffsetBlock(BlockLocation location, int face) {
		int x = location.getX(), y = location.getY(), z = location.getZ();
		switch (face) {
			case 0:
				return new BlockLocation(x, y + 1, z);
			case 1:
				return new BlockLocation(x, y - 1, z);
			case 2:
				return new BlockLocation(x, y, z + 1);
			case 3:
				return new BlockLocation(x, y, z - 1);
			case 4:
				return new BlockLocation(x + 1, y, z);
			case 5:
				return new BlockLocation(x - 1, y, z);
			default:
				return null;
		}
	}

	public void face(double x, double y, double z) {
		yaw = MathHelper.calcYaw(this.x, this.z, x, z);
		pitch = MathHelper.calcPitch(this.x, this.y, this.z, x, y, z);
	}

	public BoundingBox getBoundingBox() {
		return getBoundingBoxAt(x, y, z);
	}

	public BoundingBox getBoundingBoxAt(BlockLocation location) {
		return getBoundingBoxAt(location.getX(), location.getY(), location.getZ());
	}

	public BoundingBox getBoundingBoxAt(double x, double y, double z) {
		return BoundingBox.getBoundingBox(x - (width / 2.0), y - (height / 2.0), z - (width / 2.0), x + (width / 2.0), y + (height / 2.0), z + (width / 2.0));
	}

	@Override
	public boolean isOnGround() {
		return distanceToGround() < 0.08;
		// BoundingBox bounds = getBoundingBox();
		// Set<Block> colliding = world.getCollidingBlocks(bounds.offset(0,
		// -0.1, 0));
		// colliding.removeAll(world.getCollidingBlocks(bounds));
		// return !colliding.isEmpty();
	}

	public void accelerate(double horizAngle, double vertAngle, double accel) {
		motX += accel * Math.cos(horizAngle) * Math.cos(vertAngle);
		motZ += accel * Math.sin(horizAngle) * Math.cos(vertAngle);
		motY += accel * Math.sin(vertAngle);
	}

	public void accelerate(double horizAngle, double vertAngle, double accel, double velocityBound) {
		double ax = Math.abs(accel * Math.cos(horizAngle) * Math.cos(vertAngle));
		double az = Math.abs(accel * Math.sin(horizAngle) * Math.cos(vertAngle));
		double ay = Math.abs(accel * Math.sin(vertAngle));
		double vxb = velocityBound * Math.cos(horizAngle) * Math.cos(vertAngle);
		double vzb = velocityBound * Math.sin(horizAngle) * Math.cos(vertAngle);
		double vyb = velocityBound * Math.sin(vertAngle);
		if ((vxb < 0) && (motX > vxb))
			motX = Math.max(vxb, motX - ax);
		else if ((vxb > 0) && (motX < vxb))
			motX = Math.min(vxb, motX + ax);
		if ((vzb < 0) && (motZ > vzb))
			motZ = Math.max(vzb, motZ - az);
		else if ((vzb > 0) && (motZ < vzb))
			motZ = Math.min(vzb, motZ + az);
		if ((vyb < 0) && (motY > vyb))
			motY = Math.max(vyb, motY - ay);
		else if ((vyb > 0) && (motY < vyb))
			motY = Math.min(vyb, motY + ay);
		System.out.println("motx " + motX + " moty " + motY + " motz " + motZ);
	}

	public boolean isInLiquid() {
		return isInWater() || isInLava();
	}

	public boolean isInWater() {
		return isInBlockType(BlockType.WATER) || isInBlockType(BlockType.STATIONARY_WATER);
	}

	public boolean isInLava() {
		return isInBlockType(BlockType.LAVA) || isInBlockType(BlockType.STATIONARY_LAVA);
	}

	private boolean isInBlockType(BlockType type) {
		return checkBlockType(type, x + 0.3, y, z + 0.3) || checkBlockType(type, x + 0.3, y, z - 0.3) || checkBlockType(type, x - 0.3, y, z + 0.3)
				|| checkBlockType(type, x - 0.3, y, z - 0.3) || checkBlockType(type, x + 0.3, y + 1, z + 0.3) || checkBlockType(type, x + 0.3, y + 1, z - 0.3)
				|| checkBlockType(type, x - 0.3, y + 1, z + 0.3) || checkBlockType(type, x - 0.3, y + 1, z - 0.3) || checkBlockType(type, x + 0.3, y + 1.8, z + 0.3)
				|| checkBlockType(type, x + 0.3, y + 1.8, z - 0.3) || checkBlockType(type, x - 0.3, y + 1.8, z + 0.3) || checkBlockType(type, x - 0.3, y + 1.8, z - 0.3);
	}

	private boolean checkBlockType(BlockType type, double dx, double dy, double dz) {
		int x = (int) Math.floor(dx), y = (int) Math.floor(dy), z = (int) Math.floor(dz);
		return type.getData() == world.getBlockData(new BlockLocation(x, y, z));
	}

	@Override
	public void setCrouching(boolean crouching) {
		if (crouching != isCrouching) {
			super.setCrouching(crouching);
			controller.crouch(crouching);
		}
	}

	@Override
	public void setSprinting(boolean sprinting) {
		if (sprinting != isSprinting) {
			super.setSprinting(sprinting);
			controller.sprint(sprinting);
		}
	}

	public void swingArm() {
		bus.dispatch(new ArmSwingEvent());
	}

	public boolean switchTools(ToolType tool) {
		LocalPlayer player = world.getLocalPlayer();
		if (player == null)
			return false;
		PlayerInventory inventory = player.getInventory();
		ItemStack bestTool = null;
		int bestToolSlot = -1, bestToolValue = -1;
		for (int i = 0; i < 36; i++) {
			ItemStack item = inventory.getItemAt(i);
			if (tool == null) {
				if (i > 8)
					break;
				if ((item == null) || (ToolType.getById(item.getId()) == null)) {
					bestTool = item;
					bestToolSlot = i;
					break;
				}
				continue;
			}
			if (item == null)
				continue;
			ToolType toolType = ToolType.getById(item.getId());
			if ((toolType == null) || (toolType != tool))
				continue;
			int toolValue = getToolPriority(item.getId());
			if ((bestTool == null) || (toolValue > bestToolValue)) {
				bestTool = item;
				bestToolSlot = i;
				bestToolValue = toolValue;
			}
		}
		if (bestToolSlot == -1)
			return false;
		return switchHeldItems(bestToolSlot);
	}

	private int getToolPriority(int id) {
		ToolType type = ToolType.getById(id);
		if (type == null)
			return 0;
		int[] ids = type.getIds();
		for (int i = 0; i < ids.length; i++)
			if (id == ids[i])
				return i + 1;
		return 0;
	}

	public boolean switchHeldItems(int newSlot) {
		if (inventory.getCurrentHeldSlot() == newSlot)
			return true;
		if (newSlot > 8) {
			int hotbarSpace = 9;
			for (int hotbarIndex = 0; hotbarIndex < 9; hotbarIndex++) {
				ItemStack item = inventory.getItemAt(hotbarIndex);
				if (item == null) {
					hotbarSpace = hotbarIndex;
					break;
				} else if ((ToolType.getById(item.getId()) == null) && (hotbarIndex < hotbarSpace))
					hotbarSpace = hotbarIndex;
			}
			if (hotbarSpace == 9)
				hotbarSpace = 0;
			inventory.selectItemAt(newSlot);
			inventory.selectItemAt(hotbarSpace);
			if (inventory.getSelectedItem() != null)
				inventory.selectItemAt(newSlot);
			inventory.close();
			newSlot = hotbarSpace;
		}
		inventory.setCurrentHeldSlot(newSlot);
		return true;
	}

	public void hit(Entity entity) {
		bus.dispatch(new ArmSwingEvent());
		bus.dispatch(new EntityHitEvent(entity));
	}

	public void use(Entity entity) {
		bus.dispatch(new ArmSwingEvent());
		bus.dispatch(new EntityUseEvent(entity));
	}

	@Override
	public void updateMetadata(Map<Integer, Object> metadata) {
		super.updateMetadata(metadata);

		if (metadata.containsKey(10)) {
			System.out.println("le view " + metadata.get(10) + " " + metadata.get(10).getClass());
		}

		System.out.println("i got: " + Arrays.toString(metadata.keySet().toArray()));
	}

	public void jump() {
		motY = 0;
		motY += 0.24;
	}
}
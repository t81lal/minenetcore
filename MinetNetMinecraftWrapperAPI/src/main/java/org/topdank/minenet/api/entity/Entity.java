package org.topdank.minenet.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.PreciseLocation;
import org.topdank.minenet.api.world.DefaultMinecraftWorld;
import org.topdank.minenet.api.world.WatchableObject;

public abstract class Entity extends WatchableObject {

	protected final DefaultMinecraftWorld world;

	protected boolean isOnFire;
	protected boolean isCrouching;
	protected boolean isSprinting;
	protected boolean isRightClicking;
	protected boolean isInvisible;

	protected int breathTimer;

	protected float width;
	protected float height;

	protected double x;
	protected double y;
	protected double z;
	protected double motX;
	protected double motY;
	protected double motZ;
	protected float yaw;
	protected float pitch;
	protected float headYaw;

	protected Entity riding;
	protected Entity rider;

	protected boolean isDead;
	protected boolean isOnGround;

	public Entity(final DefaultMinecraftWorld world, final int id, float defaultWidth, float defaultHeight) {
		super(id);
		this.world = world;
		width = defaultWidth;
		height = defaultHeight;
	}

	public boolean isOnFire() {
		return isOnFire;
	}

	public void setOnFire(boolean isOnFire) {
		this.isOnFire = isOnFire;
	}

	public boolean isCrouching() {
		return isCrouching;
	}

	public void setCrouching(boolean isCrouching) {
		this.isCrouching = isCrouching;
	}

	public boolean isSprinting() {
		return isSprinting;
	}

	public void setSprinting(boolean isSprinting) {
		this.isSprinting = isSprinting;
	}

	public boolean isRightClicking() {
		return isRightClicking;
	}

	public void setRightClicking(boolean isRightClicking) {
		this.isRightClicking = isRightClicking;
	}

	public boolean isInvisible() {
		return isInvisible;
	}

	public void setInvisible(boolean isInvisible) {
		this.isInvisible = isInvisible;
	}

	public int getBreathTimer() {
		return breathTimer;
	}

	public void setBreathTimer(int breathTimer) {
		this.breathTimer = breathTimer;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setLocation(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setLocation(BlockLocation loc) {
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
	}

	public void setLocation(PreciseLocation loc) {
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
	}

	public PreciseLocation getLocation() {
		return new PreciseLocation(x, y, z);
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public double getMotionX() {
		return motX;
	}

	public void setMotionX(double motX) {
		this.motX = motX;
		// if ((motX == 0) && (motY == 0) && (motZ == 0)) {
		// world.unwatch(this);
		// } else {
		// world.watch(this);
		// }
	}

	public double getMotionY() {
		return motY;
	}

	public void setMotionY(double motY) {
		this.motY = motY;
		// if ((motX == 0) && (motY == 0) && (motZ == 0)) {
		// world.unwatch(this);
		// } else {
		// world.watch(this);
		// }
	}

	public double getMotionZ() {
		return motZ;
	}

	public void setMotionZ(double motZ) {
		this.motZ = motZ;
		// if ((motX == 0) && (motY == 0) && (motZ == 0)) {
		// world.unwatch(this);
		// } else {
		// world.watch(this);
		// }
	}

	public void setMotion(double x, double y, double z) {
		motX = x;
		motY = y;
		motZ = z;

		// if ((motX == 0) && (motY == 0) && (motZ == 0)) {
		// world.unwatch(this);
		// } else {
		// world.watch(this);
		// }
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getHeadYaw() {
		return headYaw;
	}

	public void setHeadYaw(float headYaw) {
		this.headYaw = headYaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public Entity getRiding() {
		return riding;
	}

	public void setRiding(Entity riding) {
		this.riding = riding;
	}

	public Entity getRider() {
		return rider;
	}

	public void setRider(Entity rider) {
		this.rider = rider;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isOnGround() {
		return isOnGround;
	}

	public void setOnGround(boolean isOnGround) {
		this.isOnGround = isOnGround;
	}

	public void updateMetadata(Map<Integer, Object> metadata) {
		if (metadata.containsKey(0)) {
			byte flags = (byte) metadata.get(0);
			setOnFire((flags & 0x01) != 0);
			setCrouching((flags & 0x02) != 0);
			setSprinting((flags & 0x08) != 0);
			setRightClicking((flags & 0x10) != 0);
			setInvisible((flags & 0x20) != 0);
		}

		if (metadata.containsKey(1)) {
			setBreathTimer((short) metadata.get(1));
		}
	}

	public void updateProperty(Map<String, EntityProperty> properties) {

	}

	@Override
	public void update() {
		x += motX;
		y += motY;
		z += motZ;
	}

	public static class EntityProperty {

		private final String name;
		private final double value;
		private final List<Modifier> modifiers;

		public EntityProperty(String name, double value) {
			this.name = name;
			this.value = value;
			modifiers = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public double getValue() {
			return value;
		}

		public Modifier[] getModifiers() {
			return modifiers.toArray(new Modifier[modifiers.size()]);
		}

		public void addModifier(UUID uuid, double amount, int operation) {
			modifiers.add(new Modifier(uuid, amount, operation));
		}

		public final class Modifier {

			private final UUID uuid;
			private final double amount;
			private final int operation;

			private Modifier(UUID uuid, double amount, int operation) {
				this.uuid = uuid;
				this.amount = amount;
				this.operation = operation;
			}

			public UUID getUUID() {
				return uuid;
			}

			public double getAmount() {
				return amount;
			}

			public int getOperation() {
				return operation;
			}
		}
	}
}
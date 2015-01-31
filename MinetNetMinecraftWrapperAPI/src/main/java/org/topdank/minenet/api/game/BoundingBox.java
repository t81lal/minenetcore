package org.topdank.minenet.api.game;

import org.topdank.minenet.api.game.location.BlockLocation;
import org.topdank.minenet.api.game.location.PreciseLocation;

/**
 * @author Darkstorm
 */
public final class BoundingBox {

	public static final BoundingBox NORMAL_BOUNDING_BOX = create(0, 0, 0, 1, 1, 1);

	private final float minX, minY, minZ;
	private final float maxX, maxY, maxZ;

	public static BoundingBox create(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		return new BoundingBox(Math.min(minX, maxX), Math.min(minY, maxY), Math.min(minZ, maxZ), Math.max(minX, maxX), Math.max(minY, maxY), Math.max(minZ, maxZ));
	}

	protected BoundingBox(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public BoundingBox expandBy(float x, float y, float z) {
		if (((x + 0.0) == 0) && ((y + 0.0) == 0) && ((z + 0.0) == 0))
			return this;
		float newMinX = minX, newMinY = minY, newMinZ = minZ;
		float newMaxX = maxX, newMaxY = maxY, newMaxZ = maxZ;
		if (x < 0)
			newMinX += x;
		else
			newMaxX += x;
		if (y < 0)
			newMinY += y;
		else
			newMaxY += y;
		if (z < 0)
			newMinZ += z;
		else
			newMaxZ += z;
		return create(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
	}

	public BoundingBox expand(float offX, float offY, float offZ) {
		if (((offX + 0.0) == 0) && ((offY + 0.0) == 0) && ((offZ + 0.0) == 0))
			return this;
		float newMinX = minX - offX, newMinY = minY - offY, newMinZ = minZ - offZ;
		float newMaxX = maxX + offX, newMaxY = maxY + offY, newMaxZ = maxZ + offZ;
		if (newMinX > newMaxX)
			newMinX = newMaxX = (float) ((newMinX + newMaxX) / 2.0);
		if (newMinY > newMaxY)
			newMinY = newMaxY = (float) ((newMinY + newMaxY) / 2.0);
		if (newMinZ > newMaxZ)
			newMinZ = newMaxZ = (float) ((newMinZ + newMaxZ) / 2.0);
		return create(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
	}

	public BoundingBox contract(float offX, float offY, float offZ) {
		return expand(-offX, -offY, -offZ);
	}

	public BoundingBox offset(float offX, float offY, float offZ) {
		if (((offX + 0.0) == 0) && ((offY + 0.0) == 0) && ((offZ + 0.0) == 0))
			return this;
		return create(minX + offX, minY + offY, minZ + offZ, maxX + offX, maxY + offY, maxZ + offZ);
	}

	public BoundingBox offset(PreciseLocation location) {
		return offset((float) location.getX(), (float) location.getY(), (float) location.getZ());
	}

	public BoundingBox offset(BlockLocation location) {
		return offset(location.getX(), location.getY(), location.getZ());
	}

	public BoundingBox include(float x, float y, float z) {
		return create(Math.min(minX, x), Math.min(minY, y), Math.min(minZ, z), Math.max(maxX, x), Math.max(maxY, y), Math.max(maxZ, z));
	}

	public float boundedShiftX(BoundingBox other, float offX) {
		if ((minY >= other.getMaxY()) || (maxY <= other.getMinY()) || (minZ >= other.getMaxZ()) || (maxZ <= other.getMinZ()))
			return offX;
		if ((offX > 0) && (minX >= other.getMaxX())) {
			float diffX = minX - other.getMaxX();
			if (diffX < offX)
				return diffX;
		} else if ((offX < 0) && (maxX <= other.getMinX())) {
			float diffX = maxX - other.getMinX();
			if (diffX > offX)
				return diffX;
		}
		return offX;
	}

	public float boundedShiftY(BoundingBox other, float offY) {
		if ((minX >= other.getMaxX()) || (maxX <= other.getMinX()) || (minZ >= other.getMaxZ()) || (maxZ <= other.getMinZ()))
			return offY;
		if ((offY > 0) && (minY >= other.getMaxY())) {
			float diffY = minY - other.getMaxY();
			if (diffY < offY)
				return diffY;
		} else if ((offY < 0) && (maxY <= other.getMinY())) {
			float diffY = maxY - other.getMinY();
			if (diffY > offY)
				return diffY;
		}
		return offY;
	}

	public float boundedShiftZ(BoundingBox other, float offZ) {
		if ((minX >= other.getMaxX()) || (maxX <= other.getMinX()) || (minY >= other.getMaxY()) || (maxY <= other.getMinY()))
			return offZ;
		if ((offZ > 0) && (minZ >= other.getMaxZ())) {
			float diffZ = minZ - other.getMaxZ();
			if (diffZ < offZ)
				return diffZ;
		} else if ((offZ < 0) && (maxZ <= other.getMinZ())) {
			float diffZ = maxZ - other.getMinZ();
			if (diffZ > offZ)
				return diffZ;
		}
		return offZ;
	}

	public boolean intersectsWith(BoundingBox other) {
		if ((minX >= other.getMaxX()) || (maxX <= other.getMinX()))
			return false;
		if ((minY >= other.getMaxY()) || (maxY <= other.getMinY()))
			return false;
		if ((minZ >= other.getMaxZ()) || (maxZ <= other.getMinZ()))
			return false;
		return true;
	}

	public boolean contains(BlockLocation location) {
		return contains(location.getX(), location.getY(), location.getZ());
	}

	public boolean contains(float x, float y, float z) {
		if ((minX >= x) || (maxX <= x))
			return false;
		if ((minY >= y) || (maxY <= y))
			return false;
		if ((minZ >= z) || (maxZ <= z))
			return false;
		return true;
	}

	public float getMinX() {
		return minX;
	}

	public float getMinY() {
		return minY;
	}

	public float getMinZ() {
		return minZ;
	}

	public float getMaxX() {
		return maxX;
	}

	public float getMaxY() {
		return maxY;
	}

	public float getMaxZ() {
		return maxZ;
	}

	public BlockLocation getMin() {
		return new BlockLocation(minX, minY, minZ);
	}

	public BlockLocation getMax() {
		return new BlockLocation(maxX, maxY, maxZ);
	}

	public float getWidth() {
		return maxX - minX;
	}

	public float getLength() {
		return maxZ - minZ;
	}

	public float getHeight() {
		return maxY - minY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + Float.floatToIntBits(maxX);
		result = (prime * result) + Float.floatToIntBits(maxY);
		result = (prime * result) + Float.floatToIntBits(maxZ);
		result = (prime * result) + Float.floatToIntBits(minX);
		result = (prime * result) + Float.floatToIntBits(minY);
		result = (prime * result) + Float.floatToIntBits(minZ);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoundingBox other = (BoundingBox) obj;
		if (Float.floatToIntBits(maxX) != Float.floatToIntBits(other.maxX))
			return false;
		if (Float.floatToIntBits(maxY) != Float.floatToIntBits(other.maxY))
			return false;
		if (Float.floatToIntBits(maxZ) != Float.floatToIntBits(other.maxZ))
			return false;
		if (Float.floatToIntBits(minX) != Float.floatToIntBits(other.minX))
			return false;
		if (Float.floatToIntBits(minY) != Float.floatToIntBits(other.minY))
			return false;
		if (Float.floatToIntBits(minZ) != Float.floatToIntBits(other.minZ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoundingBox[[" + minX + "," + minY + "," + minZ + "],[" + maxX + "," + maxY + "," + maxZ + "]]";
	}
}
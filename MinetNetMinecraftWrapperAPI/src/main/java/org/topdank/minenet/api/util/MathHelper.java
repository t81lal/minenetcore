package org.topdank.minenet.api.util;

public final class MathHelper {
	
	/**
	 * Calculates the yaw rotation (x axis, field of view) angle from 2 locations (e1, e2). <br>
	 * @param x Location 1's x position.
	 * @param z Location 1's z position.
	 * @param x1 Location 2's x position.
	 * @param z1 Location 2's z position.
	 * @return The yaw.
	 */
	public static float calcYaw(double x, double z, double x1, double z1) {
		double d = x - x1;
		double d1 = z - z1;
		return (float) (((Math.atan2(d1, d) * 180D) / Math.PI) + 90) % 360;
	}
	
	/**
	 * Calculates the pitch rotation (y axis, elevation) angle from 2 locations (e1, e2). <br>
	 * @param x Location 1's x position.
	 * @param y Location 1's y position.
	 * @param z Location 1's z position.
	 * @param x1 Location 2's x position.
	 * @param y1 Location 2's y position.
	 * @param z1 Location 2's z position.
	 * @return The pitch.
	 */
	public static float calcPitch(double x, double y, double z, double x1, double y1, double z1) {
		double dis1 = y1 - (y + 1);
		double dis2 = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(z1 - z, 2));
		return (float) ((Math.atan2(dis2, dis1) * 180D) / Math.PI) - 90F;
	}
}
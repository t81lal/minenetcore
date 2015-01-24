package org.topdank.minenet.api.world.block;

import java.util.Arrays;

public class ShortArray3d {

	private short[] data;

	public ShortArray3d(int size) {
		data = new short[size];
	}

	public ShortArray3d(short[] array) {
		data = array;
	}

	public boolean contains(int x, int y, int z) {
		int index = (y << 8) | (z << 4) | x;
		return !(index > data.length);
	}

	public short[] getData() {
		return data;
	}

	public int get(int x, int y, int z) {
		return data[(y << 8) | (z << 4) | x] & 0xFFFF;
	}

	public void set(int x, int y, int z, int val) {
		data[(y << 8) | (z << 4) | x] = (short) val;
	}

	public int getBlock(int x, int y, int z) {
		return get(x, y, z) >> 4;
	}

	public void setBlock(int x, int y, int z, int block) {
		set(x, y, z, (block << 4) | this.getData(x, y, z));
	}

	public int getData(int x, int y, int z) {
		return get(x, y, z) & 0xF;
	}

	public void setData(int x, int y, int z, int data) {
		set(x, y, z, (getBlock(x, y, z) << 4) | data);
	}

	public void setBlockAndData(int x, int y, int z, int block, int data) {
		set(x, y, z, (block << 4) | data);
	}

	public void fill(int val) {
		Arrays.fill(data, (short) val);
	}
}
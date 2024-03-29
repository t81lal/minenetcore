package org.topdank.minenet.lib.network.packet.header;

import java.io.IOException;

import org.topdank.minenet.lib.network.io.ReadableInput;
import org.topdank.minenet.lib.network.io.WriteableOutput;

/**
 * The header of a protocol's packets.
 */
public interface PacketHeader {
	/**
	 * Gets whether the header's length value can vary in size.
	 *
	 * @return Whether the header's length value can vary in size.
	 */
	public boolean isLengthVariable();
	
	/**
	 * Gets the size of the header's length value.
	 *
	 * @return The length value's size.
	 */
	public int getLengthSize();
	
	/**
	 * Gets the size of the header's length value.
	 *
	 * @param length Length value to get the size of.
	 * @return The length value's size.
	 */
	public int getLengthSize(int length);
	
	/**
	 * Reads the length of a packet from the given input.
	 *
	 * @param in Input to read from.
	 * @param available Number of available bytes in the ReadableInput.
	 * @return The resulting packet length.
	 * @throws java.io.IOException If an I/O error occurs.
	 */
	public int readLength(ReadableInput in, int available) throws IOException;
	
	/**
	 * Writes the length of a packet to the given output.
	 *
	 * @param out Output to write to.
	 * @param length Length to write.
	 * @throws java.io.IOException If an I/O error occurs.
	 */
	public void writeLength(WriteableOutput out, int length) throws IOException;
	
	/**
	 * Reads the ID of a packet from the given input.
	 *
	 * @param in Input to read from.
	 * @return The resulting packet ID, or -1 if the packet should not be read yet.
	 * @throws java.io.IOException If an I/O error occurs.
	 */
	public int readPacketId(ReadableInput in) throws IOException;
	
	/**
	 * Writes the ID of a packet to the given output.
	 *
	 * @param out Output to write to.
	 * @param packetId Packet ID to write.
	 * @throws java.io.IOException If an I/O error occurs.
	 */
	public void writePacketId(WriteableOutput out, int packetId) throws IOException;
}
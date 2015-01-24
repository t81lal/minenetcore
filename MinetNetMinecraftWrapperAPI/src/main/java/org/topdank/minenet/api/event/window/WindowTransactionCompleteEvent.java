package org.topdank.minenet.api.event.window;

public class WindowTransactionCompleteEvent extends WindowEvent {
	
	private final short transactionId;
	private final boolean accepted;
	
	public WindowTransactionCompleteEvent(int windowId, short transactionId, boolean accepted) {
		super(windowId);
		this.transactionId = transactionId;
		this.accepted = accepted;
	}
	
	public short getTransactionId() {
		return transactionId;
	}
	
	public boolean isAccepted() {
		return accepted;
	}
}
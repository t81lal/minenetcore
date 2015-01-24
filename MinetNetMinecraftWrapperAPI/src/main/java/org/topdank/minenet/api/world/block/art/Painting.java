package org.topdank.minenet.api.world.block.art;

public class Painting {
	
	/** Holds the maximum length of paintings art title. */
	public static final int MAX_ART_TITLE_LENGTH = "SkullAndRoses".length();
	
	/** Painting Title. */
	public final String title;
	public final int sizeX;
	public final int sizeY;
	public final int offsetX;
	public final int offsetY;
	
	// gson can call
	private Painting(String par3Str, int par4, int par5, int par6, int par7) {
		title = par3Str;
		sizeX = par4;
		sizeY = par5;
		offsetX = par6;
		offsetY = par7;
	}
	
	@Override
	public String toString() {
		return title;
	}
	
	// public static void main(String[] args) throws IOException {
	// BufferedWriter bw = new BufferedWriter(new FileWriter(new File("res/arts.registry")));
	// ArtType[] vals = ArtType.values();
	// IdentifiableObject[] os = new IdentifiableObject[vals.length];
	// for (int i = 0; i < vals.length; i++) {
	// os[i] = new IdentifiableObject(i, vals[i].title, new Art(vals[i]));
	// }
	// Gson gson = new GsonBuilder().setPrettyPrinting().create();
	// bw.write(gson.toJson(os));
	// bw.close();
	// }
}
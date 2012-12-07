package main;

public class Magic {
	static int red, blue, green, purple, mana, currentMana;
	static int redCost, blueCost, greenCost, purpleCost;
	public Magic (int R, int B, int G, int P, int RC, int BC, int GC, int PC, int Ma, int CM){
		red = R;
		blue = B;
		green = G;
		purple = P;
		redCost = RC;
		blueCost = BC;
		greenCost = GC;
		purpleCost = PC;
		mana = Ma;
		currentMana = CM;
	}
}
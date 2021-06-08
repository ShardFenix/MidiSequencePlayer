package midi;

public class Sandbox implements Function {

	@Override
	public int getNthValue(int n) {
		Float f = (float)n;
		
		return f.floatToIntBits(f);
	}
	
	
	
}

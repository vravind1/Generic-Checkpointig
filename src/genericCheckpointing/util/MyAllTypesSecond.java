package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{

	int myIntS = 17;
	String myStringS = "Anti Patterns";
	float myFloatS =  (float) 314.0;
	short myShortS = 19;
	char myCharS = 'P';

	
	public int getMyIntS() {
		return myIntS;
	}
	public void setmyIntS(int myIntS) {
		this.myIntS = myIntS;
	}
	public String getMyStringS() {
		return myStringS;
	}
	public void setmyStringS(String myStringS) {
		this.myStringS = myStringS;
	}
	public float getMyFloatS() {
		return myFloatS;
	}
	public void setmyFloatS(float myFloatS) {
		this.myFloatS = myFloatS;
	}
	public short getMyShortS() {
		return myShortS;
	}
	public void setmyShortS(short myShortS) {
		this.myShortS = myShortS;
	}
	public char getMyCharS() {
		return myCharS;
	}
	public void setmyCharS(char myCharS) {
		this.myCharS = myCharS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharS;
		result = prime * result + Float.floatToIntBits(myFloatS);
		result = prime * result + myIntS;
		result = prime * result + myShortS;
		result = prime * result
				+ ((myStringS == null) ? 0 : myStringS.hashCode());
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
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharS != other.myCharS)
			return false;
		if (Float.floatToIntBits(myFloatS) != Float
				.floatToIntBits(other.myFloatS))
			return false;
		if (myIntS != other.myIntS)
			return false;
		if (myShortS != other.myShortS)
			return false;
		if (myStringS == null) {
			if (other.myStringS != null)
				return false;
		} else if (!myStringS.equals(other.myStringS))
			return false;
		return true;
	}
	
}

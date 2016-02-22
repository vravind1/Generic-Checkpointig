package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{

	int myInt = 17;
	String myString = "Design Patterns";
	double myDouble = 3.14;
	long myLong = 1212121;
	char myChar = 'D';
	
	public int getMyInt() {
		return myInt;
	}
	public void setmyInt(int myInt) {
		this.myInt = myInt;
	}
	public String getMyString() {
		return myString;
	}
	public void setmyString(String myString) {
		this.myString = myString;
	}
	public double getMyDouble() {
		return myDouble;
	}
	public void setmyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setmyLong(long myLong) {
		this.myLong = myLong;
	}
	public char getMyChar() {
		return myChar;
	}
	public void setmyChar(char myChar) {
		this.myChar = myChar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myChar;
		long temp;
		temp = Double.doubleToLongBits(myDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result
				+ ((myString == null) ? 0 : myString.hashCode());
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
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myChar != other.myChar)
			return false;
		if (Double.doubleToLongBits(myDouble) != Double
				.doubleToLongBits(other.myDouble))
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}
}
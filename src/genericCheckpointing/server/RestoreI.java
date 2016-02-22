package genericCheckpointing.server;


import java.io.BufferedReader;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.util.SerializableObject;


public interface RestoreI extends StoreRestoreI{
	SerializableObject readObj(Strategy strategy, BufferedReader bufR);

}

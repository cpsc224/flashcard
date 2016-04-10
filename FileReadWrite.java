import java.nio.file.*;

import java.io.*;

/**
 * 
 * @author Alex Love
 * @class FileReadWrite
 * Class that utilizes object serialization in order to save and read files.
 *
 */
public class FileReadWrite {

	public void saveFile(String fileName, ProfileManager p) throws IOException{
		File f = new File(fileName);
		try {
			f.createNewFile();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		FileOutputStream fo = new FileOutputStream(f);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		output.writeObject(p);//write object to file
		fo.close();
		output.close();
		}
	
	public ProfileManager readFile(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fi = new FileInputStream(fileName);
		ObjectInputStream input = new ObjectInputStream(fi);
		ProfileManager p = new ProfileManager();
		try{
			while(true){
				 p = (ProfileManager) input.readObject();
			}
		}
		catch(EOFException e){};
		return p;
	}
	
}

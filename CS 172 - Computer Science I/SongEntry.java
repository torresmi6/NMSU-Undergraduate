public class SongEntry

{
   //Declare private data members.
private String uniqueID;

private String songName;

private String artistName;

private int songLength;

SongEntry nextNode;
  
//Default constructor.
SongEntry()

{
  
uniqueID = "none";

songName = "none";

artistName = "none";

songLength = 0;

nextNode = null;

}
  
//Parameterized constructor
SongEntry(String uniqueID, String songName, String artistName, int songLength)

{

this.uniqueID = uniqueID;

this.songName = songName;

this.songLength = songLength;

this.artistName = artistName;

this.nextNode = null;

}
  
public void insertAfter( SongEntry entry)

{
  
SongEntry entries = this;

while(entries.nextNode != null)

{

entries = entries.nextNode;

}

entries.nextNode = entry;

}
  
public void setNext(SongEntry entry){

this.nextNode = entry;

}
  
public String getID()

{

return this.uniqueID;

}
  
public String getSongName()

{

return this.songName;

}
  
public String getArtistName()

{

return this.artistName;

}
  
public int getSongLength()

{

return this.songLength;

}
  
public SongEntry getNext()

{

return this.nextNode;

}
  
public void setUniqueID(String uniqueID)

{

this.uniqueID = uniqueID;

}
  
public void setSongName(String songName)

{

this.songName=songName;

}
  
public void setArtistName(String artistName)

{

this.artistName=artistName;

}
  
  
public void setSongLength(int songLength )

{

this.songLength=songLength;

}
  
public void printPlaylistSongs()

{

System.out.println("Unique ID: "+getID());

System.out.println("Song Name: "+getSongName());

System.out.println("Artist Name: "+getArtistName());

System.out.println("Song Length(in seconds): "+getSongLength());

}

}
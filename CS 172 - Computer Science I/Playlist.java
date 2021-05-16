import java.util.Scanner;

public class Playlist
{

   
   public static Scanner scnr = new Scanner(System.in);

  
   public static SongEntry headSong = new SongEntry();
  
   public static SongEntry tailSong = new SongEntry();

   public static SongEntry allEntries;

   public static int numberOfNodes = 0;
  
   public static void printMenu(String playlistTitle)

   {
  
   System.out.println("\n"+playlistTitle + " PLAYLIST MENU");

   System.out.println("a - Add song\nd - Remove song\nc - Change position "
           + "of song\ns - Output songs by specific artist");

   System.out.println("t - Output total time of playlist (in seconds)\no "
           + "- Output full playlist\nq - Quit");
  
System.out.println("\nChoose an option:");

String option = scnr.next();
  

boolean isEnter = option.equals("a") || option.equals("d") || option.equals("c")
    || option.equals("s") || option.equals("t")
    || option.equals("o") || option.equals("q");
  

if(isEnter)

{
  
switch(option.charAt(0))

{
  
case 'a': addSong();

printMenu(playlistTitle);

break;
  
case 'd': allEntries = removeSong(allEntries);

printMenu(playlistTitle);

break;

case 'c': allEntries = changeSongPosition(allEntries);

printMenu(playlistTitle);

break;


case 's': songsBySpecificArtist(allEntries);

printMenu(playlistTitle);

break;
  

case 't': totalTimeofPlaylist(allEntries);

printMenu(playlistTitle);

break;

case 'o': 

System.out.println(playlistTitle + " - OUTPUT FULL PLAYLIST");
outputFullPlaylist(allEntries);

printMenu(playlistTitle);

break;

case 'q': break;

}

}
  

else

{

System.out.println("Invalid Choice !");

printMenu(playlistTitle);

}

}

public static void outputFullPlaylist(SongEntry entries)

{

int counter = 1;

if(entries != null)

{
  
System.out.println(counter+".");
  

entries.printPlaylistSongs();

counter++;
  

while(entries.nextNode != null) 
{

entries = entries.nextNode;

System.out.println(counter+".");

entries.printPlaylistSongs();

counter++;

}

}
  

else

{

System.out.println("Playlist is empty");

}

}


public static void addSong()

{
  
System.out.println("ADD SONG");

System.out.println("Enter song's Unique ID:");

String songID = scnr.next();

Scanner scnr = new Scanner(System.in);
System.out.println("Enter song's name:");

String songname = scnr.nextLine();


System.out.println("Enter artist's name:");

String artistName = scnr.nextLine();

System.out.println("Enter song's length(in seconds):");

int songlength = scnr.nextInt();

SongEntry entry = new SongEntry(songID, songname, artistName, songlength);
  

if(allEntries == null)

{

headSong = entry; 

allEntries = entry;

tailSong = entry; 

numberOfNodes++;

}
  

else

{

allEntries.insertAfter(entry);

tailSong = entry;

numberOfNodes++;

}

}


public static SongEntry removeSong(SongEntry entries)

{
System.out.println("Enter the song's unique ID:");

String id = scnr.next();

SongEntry newEntry = null, entry=null;

int counter = 0;
  

while(entries != null)

{
if(counter!=0)

{

newEntry.nextNode = null;

newEntry = newEntry.nextNode;

}  
  
  
if(!entries.getID().equals(id))

{
  
newEntry = new SongEntry();
  
  
newEntry.setUniqueID(entries.getID());

newEntry.setSongName(entries.getSongName());

newEntry.setArtistName(entries.getArtistName());

newEntry.setSongLength(entries.getSongLength());

if(entry == null)

entry = newEntry;

else

entry.insertAfter(newEntry);

counter++;

}

else

{

   System.out.println(entries.getSongName()+" removed");

numberOfNodes--;

}

entries = entries.nextNode;

}

return entry;

}


public static SongEntry changeSongPosition(SongEntry entries)

{
  
   
System.out.println("CHANGE POSITION OF SONG");

System.out.println("ENTER song's current position:");

int currentPos = scnr.nextInt();

System.out.println("Enter new position of song:");

int newPos = scnr.nextInt();

SongEntry currentPosEntry = null, entry = null, newPosEntry = null, returnEntry = null;

entry = entries;

int counter = 1;



if(newPos<1)

newPos = 1;
  
else if(newPos>numberOfNodes)
  
newPos = numberOfNodes;

System.out.println("cuurent pos: "+currentPos);

System.out.println("new pos: "+newPos);
  
  
for(int i=1; i<=numberOfNodes; i++)

{

if(i==currentPos)

currentPosEntry = entries;

else if(i==newPos)

newPosEntry = entries;

else

entries = entries.nextNode;

}


entries = entry;
  
while(counter <= numberOfNodes+1)

{

if(counter == currentPos) 
{

entries = entries.nextNode;

if(entries !=null)

{

   entry = new SongEntry(entries.getID(), entries.getSongName(),
           entries.getArtistName(), entries.getSongLength());

if(returnEntry == null)

returnEntry = entry;

else

returnEntry.insertAfter(entry);

entries = entries.nextNode;

}

counter++;

}
  
  
else if(counter == newPos)

{

entry = currentPosEntry;

entry.nextNode = null;

if(returnEntry == null)

returnEntry = entry;

else

returnEntry.insertAfter(entry);

counter++;

}

else

{

if(entries !=null)

{

   entry = new SongEntry(entries.getID(), entries.getSongName(),
           entries.getArtistName(), entries.getSongLength());

if(returnEntry == null)

returnEntry = entry;

else

returnEntry.insertAfter(entry);

entries = entries.nextNode;

}

counter++;

}

}

return returnEntry;

}

public static void totalTimeofPlaylist(SongEntry entries)

{

   System.out.println("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");

int totalSeconds = entries.getSongLength();

entries = entries.nextNode;
  
while(entries != null)

{

totalSeconds += entries.getSongLength();

entries = entries.nextNode;

}

System.out.println("Total Time: "+totalSeconds+" seconds");

}

public static void songsBySpecificArtist(SongEntry entries)

{

scnr = new Scanner(System.in);

System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
  
System.out.println("Enter artist's name:");

String artistname = scnr.nextLine();
  
while(entries != null)

{

if(entries.getArtistName().equals(artistname))

{

entries.printPlaylistSongs();

}

entries = entries.nextNode;

}

}




public static void main(String[] args)

{
System.out.println("Enter playlist's title:");

scnr = new Scanner(System.in);

String title = scnr.nextLine();
  
printMenu(title);

}

}
//Write a program in java to manage music store.
import java.util.ArrayList;
import java.util.Scanner;
public class Lab04_5 {
    static class MusicStore{
        private int count = 1;
        protected int option;
        private Scanner input = new Scanner(System.in);
        //Protected variable for user input
        protected String song_title;
        protected String singer;
        protected int song_length;
        protected int song_price;
        protected String Album_title;
        protected String Album_Genre;
        public ArrayList<Album> albums = new ArrayList<>();
        //return method to create arrayList of albums
        public ArrayList<Album> getalAlbums(){
            this.albums = new ArrayList<>();
            return albums;
        }
        //method to add music
        public void addAlbum(Album addAlbum){
            albums.add(addAlbum);
        }
        //method to display all music store
        public void AlbumDisplay(){
            for(Album AlbumObj : albums){
                System.out.println("Album: " + AlbumObj.album_name + ", Genre: " + AlbumObj.Genre);
                for(Song SongObj : AlbumObj.getSong()){
                    System.out.println("| " + count + "\t| " + SongObj.title + "\t\t| "
                            + SongObj.Author + "\t| " + SongObj.duration + "\t| " + SongObj.price + "\t|");
                    count++;
                }
            }
        }
        //method to add new song into album from user
        public void Add_Song_from_User(){
            for(int a = 0; a < albums.size(); a++){
                System.out.println((a+1) + ". " + albums.get(a).album_name);
            }
            System.out.println("Choose an option: ");
            option = input.nextInt();
            input.nextLine();
            for(int a = 0; a < albums.size(); a++){
                if(option == (a+1)){
                    System.out.println("Song title:");
                    song_title = input.nextLine();
                    System.out.println("Singer: ");
                    singer = input.nextLine();
                    System.out.println("Duration: ");
                    song_length = input.nextInt();
                    input.nextLine();
                    System.out.println("Price: ");
                    song_price = input.nextInt();
                    input.nextLine();
                    //Add new album base on user choice
                    Album selcectAlbum = albums.get(a);
                    Song song = new Song(song_title, singer, song_length, song_price);
                    selcectAlbum.addSong(song);
                }
            }
        }
        //mothod to add new album from user
        public void Add_Album_from_User(){
            System.out.println("Album title:");
            Album_title = input.nextLine();
            System.out.println("Genre: ");
            Album_Genre = input.nextLine();
            Album album = new Album(Album_title, Album_Genre);
            addAlbum(album);
        }
    }
    static class Album{
        protected String album_name;
        protected String Genre;
        public ArrayList<Song> songs;

        //constructor of class Album
        public Album(String album_name, String Genre){
            this.album_name = album_name;
            this.Genre = Genre;
            this.songs = new ArrayList<>();
        }
        //method to add music into an album
        public void addSong(Song song){
            songs.add(song);
        }

        //return method to create arrayList of songs
        public ArrayList<Song> getSong(){
            return songs;
        }
    }
    static class Song{
        String title;
        String Author;
        int duration;
        double price;
        //constructor of class song
        public Song(String title, String Author, int duration, double price){
            this.title = title;
            this.Author = Author;
            this.duration = duration;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        //Create an album called "Skull-1" and add music in that album
        Album album1 = new Album("Skull", "Hip-Hop");
        Song song1 = new Song("Solo", "Vannda", 3, 5);
        Song song2 = new Song("QueenBee", "Vannda", 5, 12);
        album1.addSong(song1);
        album1.addSong(song2);
        //Create an album called "Skull-2" and add music in that album
        Album album2 = new Album("Skull-2", "Hip-Hop");
        Song song3 = new Song("BOK KALO", "Vannda", 3, 7);
        Song song4 = new Song("Day Dreamer", "Vannda", 4, 15);
        album2.addSong(song3);
        album2.addSong(song4);
        Album album3 = new Album("Reborn", "Rap");
        Song song5 = new Song("How about now ", "G-Davith", 2, 10);
        album3.addSong(song5);
        //Create A music store
        MusicStore musicStore = new MusicStore();
        musicStore.addAlbum(album1);
        musicStore.addAlbum(album2);
        musicStore.addAlbum(album3);
        while(2>1){
            System.out.println("===== Menu =====");
            System.out.println("1. View a music store");
            System.out.println("2. Add a song");
            System.out.println("3. Create an album");
            System.out.println("4. Quit");
            System.out.println("Choose an option: ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.println("===== View a music store =====");
                    musicStore.AlbumDisplay();
                    break;
                case 2:
                    System.out.println("===== Add a song =====");
                    System.out.println("Select the following album: ");
                    musicStore.Add_Song_from_User();
                    break;
                case 3:
                    System.out.println("===== Create an album =====");
                    musicStore.Add_Album_from_User();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input :( Try again!");
                    break;
            }
        }

    }
}

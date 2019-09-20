<h1>Guess The Movie game</h1>

<h3>About the game</h3>
<p>The rules are simple, the computer randomly picks a movie title, and shows you how many letters it's made up of. Your goal is to try to figure out the movie by guessing one letter at a time.
   If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point. If you lose 10 points, game over!
   BUT the more correct letters you guess the more obvious the movie becomes and at a certain point you should be able to figure it out.
   The program will randomly pick a movie title from a text file that contains a large list of movies.
</p>

<h3>To modify the list of movies</h3>
<p>
    You can modify or update the list of movies which user can guess within 
    "resources\movies.txt". You can update the "movies.txt" file with new movies
    name.
</p>


<h3>Running the game</h3>
<p>To build and run the game, simply follow the below steps:</p>
<ol>
    <li>clone this project to your local - $git clone https://github.com/Senopratomo/guessthemovie.git</li>
    <li>run "mvn clean install" in the root directory of "guessthemovie" folder</li>
    <li>run: "java -jar target/ guessthemovie-1.0-SNAPSHOT-jar-with-dependencies.jar"</li>
    <li>Enjoy the game</li>
</ol>

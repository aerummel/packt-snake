package android.example.snake;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

public class SnakeActivity extends AppCompatActivity {

    // Declare an instance of SnakeGame
    SnakeGame mSnakeGame;

    // Set the game up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // Get the pixel dimensions of the screen
//        Display display = getWindowManager().getDefaultDisplay();
//
//        // Initialize the result into a Point object
//        Point size = new Point();
//        display.getSize(size);

        // Get the display metrics of the screen
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        // Initialize the screen size into a Point object
        Point size = new Point();
        size.x = displayMetrics.widthPixels;
        size.y = displayMetrics.heightPixels;

        // Create a new instance of the SnakeEngine class
        mSnakeGame = new SnakeGame(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(mSnakeGame);
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        mSnakeGame.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        mSnakeGame.pause();
    }
}
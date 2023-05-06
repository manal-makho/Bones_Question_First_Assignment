package com.example.androidfirstassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    com.example.firstassignment.BonesQuestions bonesQuestions=new com.example.firstassignment.BonesQuestions();
    private Button letsStartbtn;
    private Button firstchoicebtn;
    private Button secondchoicebtn;
    private Button thirdchoicebtn;
    private TextView theQuestion;
    private VideoView videoView;
    int questionCount=0;
    int amountQuestions = bonesQuestions.questions.length;
    String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letsStartbtn = findViewById(R.id.letsStartbtn);
        firstchoicebtn=findViewById(R.id.firstChoicebtn);
        secondchoicebtn=findViewById(R.id.SecondChoicebtn);
        thirdchoicebtn=findViewById(R.id.thirdChoicebtn);
        theQuestion=findViewById(R.id.theQuestion);

        //show the video
        videoView =findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bones;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        //to have the buttons in the video bar
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        letsStartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstchoicebtn.setVisibility(View.VISIBLE);
                secondchoicebtn.setVisibility(View.VISIBLE);
                thirdchoicebtn.setVisibility(View.VISIBLE);
                letsStartbtn.setVisibility(View.GONE);
                videoView.setVisibility(View.GONE);
                continueQuestion();

            }
        });

        firstchoicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstchoicebtn.getText() == correctAnswer) {
                    trueresult(correctAnswer);


                } else {
                    wrongresult(correctAnswer);
                }
            }
        });

        secondchoicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondchoicebtn.getText() == correctAnswer) {
                    trueresult(correctAnswer);


                } else {
                    wrongresult(correctAnswer);
                }
            }
        });

        thirdchoicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thirdchoicebtn.getText() == correctAnswer) {
                    trueresult(correctAnswer);


                } else {
                    wrongresult(correctAnswer);
                }
            }
        });


    }

    private void continueQuestion(){
        if (questionCount == amountQuestions) {
            finishedQuestions();

        } else {
            theQuestion.setText(bonesQuestions.getQuestion(questionCount));
            firstchoicebtn.setText(bonesQuestions.getChoice1(questionCount));
            secondchoicebtn.setText(bonesQuestions.getChoice2(questionCount));
            thirdchoicebtn.setText(bonesQuestions.getChoice3(questionCount));
            correctAnswer = bonesQuestions.getCorrectChoice(questionCount);
            questionCount++;
        }

    }

    private void finishedQuestions(){
        new AlertDialog.Builder(this)
                .setTitle("I hope you learned a lot!!")
                .setPositiveButton("Play Again!",(dialogInterface, i) -> playAgain() )
                .setCancelable(false)
                .show();
    }

    private void playAgain() {
        questionCount =0;
        continueQuestion();
    }

    private void trueresult(String str){
        if (questionCount < amountQuestions) {
            new AlertDialog.Builder(this)
                    .setTitle("The Answer is Correct")
                    .setMessage(str)
                    .setPositiveButton("Next Question", (dialogInterface, i) -> continueQuestion())
                    .setCancelable(false)
                    .show();
        }
        else{
            finishedQuestions();
        }
    }

    private void wrongresult(String str){
        if (questionCount < amountQuestions) {
            new AlertDialog.Builder(this)
                    .setTitle("This Answer was Incorrect")
                    .setMessage("The Correct Answer was: " + str)
                    .setPositiveButton("Next Question", (dialogInterface, i) -> continueQuestion())
                    .setCancelable(false)
                    .show();
        }
        else{
            finishedQuestions();
        }
    }
}
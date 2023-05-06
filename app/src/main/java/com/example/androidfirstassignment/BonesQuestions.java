package com.example.firstassignment;

public class BonesQuestions {

    public String questions[]={
            "How many Bones in Adult's bodies?",
            "What's the strongest and largest bone in our body?",
            "What's the longest, heaviest bone in our body??",
            "What's Kib Cage protects?",
            "Which bone has triangular shape?"
    };

    private String choices[][]={
            {"300","103","206"},
            {"Cranium","Mandible","Scapula"},
            {"Femur","Patella","Fibula"},
            {"Brain","Stomach","Heart and Lungs"},
            {"Rib Cage","Scapula","Humerus"}
    };


    private String correctAmswer[]={
            "206",
            "Mandible",
            "Femur",
            "Heart and Lungs",
            "Scapula"
    };

    public String getQuestion(int i) {
        return questions[i];
    }

    public String getChoice1(int i) {
        return choices[i][0];
    }

    public String getChoice2(int i) {
        return choices[i][1];
    }

    public String getChoice3(int i) {
        return choices[i][2];
    }

    public String getCorrectChoice(int i) {
        return correctAmswer[i];
    }


}

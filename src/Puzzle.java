/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
public class Puzzle {
    private String question;
    private String answer;
    private String altAnswerOne;
    private String altAnswerTwo;
    private String altAnswerThree;
    private String hint;
    private boolean isSolved;

    public Puzzle(){}
    public Puzzle(String question, String answer, String hint) {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.isSolved = false;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public String getAltAnswerOne() {
        return altAnswerOne;
    }

    public void setAltAnswerOne(String altAnswerOne) {
        this.altAnswerOne = altAnswerOne;
    }

    public String getAltAnswerTwo() {
        return altAnswerTwo;
    }

    public void setAltAnswerTwo(String altAnswerTwo) {
        this.altAnswerTwo = altAnswerTwo;
    }

    public String getAltAnswerThree() {
        return altAnswerThree;
    }

    public void setAltAnswerThree(String altAnswerThree) {
        this.altAnswerThree = altAnswerThree;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}

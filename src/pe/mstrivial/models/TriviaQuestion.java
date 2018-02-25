package pe.mstrivial.models;
import java.util.Date;
public class TriviaQuestion {
    private int id;
    private Trivia trivia;
    private Question question;
    private String answerPlayer1;
    private String answerPlayer2;
    private Date createDate;
    private Date modifyDate;

    public TriviaQuestion() {
    }

    public TriviaQuestion(int id, Trivia trivia, Question question, String answerPlayer1, String answerPlayer2, Date createDate, Date modifyDate) {
        this.id = id;
        this.trivia = trivia;
        this.question = question;
        this.answerPlayer1 = answerPlayer1;
        this.answerPlayer2 = answerPlayer2;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }


    public int getId() {
        return id;
    }

    public TriviaQuestion setId(int id) {
        this.id = id;
        return this;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public TriviaQuestion setTrivia(Trivia trivia) {
        this.trivia = trivia;
        return this;
    }

    public Question getQuestion() {
        return question;
    }

    public TriviaQuestion setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public String getAnswerPlayer1() {
        return answerPlayer1;
    }

    public TriviaQuestion setAnswerPlayer1(String answerPlayer1) {
        this.answerPlayer1 = answerPlayer1;
        return this;
    }

    public String getAnswerPlayer2() {
        return answerPlayer2;
    }

    public TriviaQuestion setAnswerPlayer2(String answerPlayer2) {
        this.answerPlayer2 = answerPlayer2;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public TriviaQuestion setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public TriviaQuestion setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}

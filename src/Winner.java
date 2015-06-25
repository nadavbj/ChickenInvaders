import java.io.Serializable;
import java.util.Date;


public class Winner implements Serializable{
private int score;
private String name;
private Date date;
private int minutes;
private int seconds;
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public Winner(int score, String name, Date date) {
	System.out.println(name);
	this.score = score;
	this.name = name;
	this.date = date;
}
}
